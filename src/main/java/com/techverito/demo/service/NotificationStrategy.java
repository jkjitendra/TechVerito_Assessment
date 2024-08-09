package com.techverito.demo.service;

import com.techverito.demo.constants.NotificationType;

public interface NotificationStrategy {

    void sendNotification(String message, String type);
}
