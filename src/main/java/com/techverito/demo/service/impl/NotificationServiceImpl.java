package com.techverito.demo.service.impl;

import com.techverito.demo.constants.NotificationType;
import com.techverito.demo.service.NotificationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl {

    private final NotificationStrategy notificationStrategy;

    public NotificationServiceImpl(NotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }

    public void sendNotification(NotificationStrategy notificationStrategy) {

//        switch (type) {
//            case "SMS": new SMSService();
//            case "EMAIL": new EmailService();
//        }

    }

    public void send(String message, String recipient) {
        notificationStrategy.sendNotification(message, recipient);
    }


}
