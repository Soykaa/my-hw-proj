package ru.java.hse.sd.runner;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.util.SerializationUtils;
import ru.java.hse.sd.model.Mark;
import ru.java.hse.sd.model.Submission;
import ru.java.hse.sd.model.hibernate.Attempt;
import ru.java.hse.sd.model.hibernate.Checker;
import ru.java.hse.sd.model.hibernate.Homework;
import ru.java.hse.sd.model.hibernate.Storage;

/**
 * Runs checks.
 **/
public class Runner {
    private static final String TASK_QUEUE_NAME = "my_hw_proj";

    /**
     * Executes runner.
     *
     * @throws Exception in case of error
     **/
    public static void main(String[] argv) throws Exception {
        var factory = new ConnectionFactory();
        factory.setHost("localhost");
        final Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();

        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        channel.basicQos(1);

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            Submission submission = (Submission) SerializationUtils.deserialize(delivery.getBody());
            try {
                if (submission == null) {
                    throw new IllegalArgumentException("Could not deserialize submission object");
                }
                process(submission);
            } finally {
                System.out.println(" [x] Done");
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            }
        };
        channel.basicConsume(TASK_QUEUE_NAME, false, deliverCallback, consumerTag -> {
        });
    }

    private static void process(Submission submission) {
        try (Session session = Storage.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Attempt attempt = session.find(Attempt.class, submission.getAttemptId());
            Homework homework = session.find(Homework.class, attempt.getHomeworkId());
            Checker checker = session.find(Checker.class, homework.getCheckerId());

            String[] commandArray = checker.getCode().split(" ");
            try {
                var processBuilder = new ProcessBuilder(commandArray);
                Process process = processBuilder.start();
                process.waitFor();
                String output = new String(process.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
                attempt.setMark(Mark.YES);
                attempt.setComment(output);
            } catch (IOException | InterruptedException e) {
                attempt.setMark(Mark.NO);
                attempt.setComment("Failed");
            }
            try {
                session.save(attempt);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw new RuntimeException(e);
            }
        }
    }
}
