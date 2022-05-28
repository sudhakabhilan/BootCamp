package com.demo.notification;

public class NotificationApplication {
    public static void main(String[] args) {

        Notification noti = new Notification();
        noti.sendMessage();

        //Notification email = new EmailNotification();
       // email.sendMessage();

		SMSNotification sms = new SMSNotification();
		sms.sendMessage();




    }

}
