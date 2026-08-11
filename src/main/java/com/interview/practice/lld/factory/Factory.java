package com.interview.practice.lld.factory;

public class Factory {
}

interface NotificationSender {
    void send(String message);
}

class EmailSender implements NotificationSender {
    public void send(String message) {}
}

class SmsSender implements NotificationSender {
    public void send(String message) {}
}

class NotificationFactory {
    static NotificationSender create(String type) {
        return switch (type) {
            case "EMAIL" -> new EmailSender();
            case "SMS" -> new SmsSender();
            default -> throw new IllegalArgumentException("Unsupported type");
        };
    }
}