package com.javarush.task.task38.task3804;

public class ExceptionFactory {

    public static Throwable getException(Enum type) {

        if (type == null) {
            return new IllegalArgumentException();
        }

        String message = type.name().charAt(0) + type.name().substring(1).replaceAll("_", " ").toLowerCase();

        if (type instanceof ExceptionApplicationMessage) {
            return new Exception(message);
        } else if (type instanceof ExceptionDBMessage) {
            return new RuntimeException(message);
        } else if (type instanceof ExceptionUserMessage) {
            return new Error(message);
        }

        return new IllegalArgumentException();
    }
}
