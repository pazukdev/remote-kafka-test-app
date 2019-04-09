package com.pazukdev.remotekafkatestapp.terminal;

import com.pazukdev.remotekafkatestapp.entity.Message;

/**
 * @author Siarhei Sviarkaltsau
 */
class InputParserUtil {

    private static final String TOPIC_DEFINITION = "topic:";
    private static final String TOPIC_PREFIX = "g2kbypl3-"; // your prefix for free instance on cloudkarafka.com

    static Message createMessage(final String input) {
        if (inputContainsTopic(input)) {
            return Message.create(input.split(getSplitter())[0]);
        } else {
            return Message.create(input);
        }
    }

    static String getTopic(final String input) {
        final String topicName = getTopicName(input);
        if (topicName != null) {
            return TOPIC_PREFIX + topicName;
        } else return null;
    }

    private static String getTopicName(final String input) {
        if (inputContainsTopic(input)) {
            return input.split(getSplitter())[1];
        } else return null;
    }

    private static boolean inputContainsTopic(final String input) {
        return input.contains(TOPIC_DEFINITION);
    }

    private static String getSplitter() {
        return String.format(" %s ", TOPIC_DEFINITION);
    }

}
