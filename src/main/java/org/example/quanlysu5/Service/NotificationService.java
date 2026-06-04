package org.example.quanlysu5.Service;

import org.example.quanlysu5.Dto.Response.Notification.NotificationResponse;

public interface NotificationService {
    void sendToAll(NotificationResponse notification);
}
