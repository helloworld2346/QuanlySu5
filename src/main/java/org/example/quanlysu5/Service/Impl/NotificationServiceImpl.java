package org.example.quanlysu5.Service.Impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.example.quanlysu5.Dto.Response.Notification.NotificationResponse;
import org.example.quanlysu5.Service.NotificationService;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class NotificationServiceImpl implements NotificationService {
    SimpMessagingTemplate messagingTemplate;
    @Override
    public void sendToAll(NotificationResponse notification) {
        messagingTemplate.convertAndSend(
                "/topic/notifications",
                notification
        );
    }
}
