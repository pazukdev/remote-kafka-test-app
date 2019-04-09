package com.pazukdev.remotekafkatestapp.entity;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
public class Message {

    private static int idCounter = 0;

    private final int id;
    private final String message;

    public static Message create(final String message) {
        return new Message(idCounter++, message);
    }

    @Override
    public String toString() {
        return String.format("%s (id: %s)", message, id);
    }

}
