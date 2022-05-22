package ru.java.hse.sd.runner;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.util.SerializationUtils;
import ru.java.hse.sd.model.Mark;
import ru.java.hse.sd.model.Submission;
import ru.java.hse.sd.model.hibernate.Attempt;
import ru.java.hse.sd.model.hibernate.Storage;


public class Runner {
    private static final String TASK_QUEUE_NAME = "my_hw_proj";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
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
        channel.basicConsume(TASK_QUEUE_NAME, false, deliverCallback, consumerTag -> { });
    }

    private static void process(Submission submission) {
        try (Session session = Storage.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Attempt attempt = session.find(Attempt.class, submission.getAttemptId());
            attempt.setMark(Mark.YES);
            attempt.setComment("Great Work!");
            try {
                session.save(attempt);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw new RuntimeException(e);
            }
        }
    }
}
