package ru.java.hse.sd.queue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import org.springframework.util.SerializationUtils;
import ru.java.hse.sd.model.Submission;

/**
 * Responsible for load balancing.
 **/
public class Balancer {
    private static final String TASK_QUEUE_NAME = "my_hw_proj";

    /**
     * Balances load.
     **/
    public void task(Submission submission) throws Exception {
        var factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
            byte[] byteArray = SerializationUtils.serialize(submission);

            channel.basicPublish("", TASK_QUEUE_NAME,
                    MessageProperties.PERSISTENT_TEXT_PLAIN,
                    byteArray);
        }
    }
}
