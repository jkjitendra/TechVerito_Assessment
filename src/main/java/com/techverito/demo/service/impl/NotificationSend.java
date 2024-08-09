package com.techverito.demo.service.impl;

import com.techverito.demo.constants.NotificationType;
import com.techverito.demo.service.NotificationStrategy;
import org.springframework.beans.factory.annotation.Autowired;

public class NotificationSend {

    private NotificationStrategy notificationStrategy;

    public NotificationSend(NotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }

    public void setNotificationStrategy(NotificationStrategy strategy){
        this.notificationStrategy = strategy;
    }

    public void send(NotificationType type) {
//        notificationStrategy.sendNotification(type);
    }

}
