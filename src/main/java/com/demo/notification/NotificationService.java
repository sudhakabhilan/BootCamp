package com.demo.notification;

public class NotificationService {

    private Notification  notification;    // decalare base class variable

    public NotificationService(Notification notification) {
        this.notification=notification;
    }

    public void sendMessage() {

        notification.sendMessage();

    }
}
