package org.example.DI;

public class SMSService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("SMS Notification: " + message);
    }
}