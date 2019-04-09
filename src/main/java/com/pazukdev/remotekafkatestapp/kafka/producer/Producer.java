package com.pazukdev.remotekafkatestapp.kafka.producer;

import com.pazukdev.remotekafkatestapp.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Siarhei Sviarkaltsau
 */
@Component
public class Producer {

    private static final Logger log = LoggerFactory.getLogger(Producer.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${cloudkarafka.default.topic}")
    private String defaultTopic;

    Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, final Message message) {
        kafkaTemplate.send(getEnsuredNotNullTopic(topic), message.getMessage());
        //log.info("message sent: " + message.getMessage());
    }

    private String getEnsuredNotNullTopic(final String topic) {
        return topic != null ? topic : defaultTopic;
    }

}
