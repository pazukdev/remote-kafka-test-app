package com.pazukdev.remotekafkatestapp.terminal;

import com.pazukdev.remotekafkatestapp.entity.Message;
import com.pazukdev.remotekafkatestapp.kafka.producer.Producer;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * @author Siarhei Sviarkaltsau
 */
@Component
@RequiredArgsConstructor
public class InputProcessor {

    private static final Logger log = LoggerFactory.getLogger(InputProcessor.class);

    private final Producer producer;

    // explicit topic definition doesn't work at the moment
    /**
     * 1. without explicit topic definition the message will be sent to default topic: yourUsername-default
     * 2. to define topic input: "<message> topic: <topic>" (the topic should be created on cloudkarafka.com)
     */
    public void processInput() {
        final Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            processInput(scanner.next());
        }
    }

    private void processInput(final String input) {
        final String topic = InputParserUtil.getTopic(input);
        final Message message = InputParserUtil.createMessage(input);

        sendMessage(topic, message);
    }

    private void sendMessage(final String topic, final Message message) {
        if (topic != null) {
            log.info("selectedTopic: " + topic);
        }
        producer.send(topic, message);
    }

}
