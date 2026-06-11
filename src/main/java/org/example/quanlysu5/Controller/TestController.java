//package org.example.quanlysu5.Controller;
//
//import lombok.RequiredArgsConstructor;
//import org.example.quanlysu5.Dto.Response.Notification.NotificationResponse;
//import org.example.quanlysu5.Service.ThongBaoService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.time.LocalDateTime;
//import java.util.UUID;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/test")
//public class TestController {
//
//    private final ThongBaoService thongBaoService;
//
//    @GetMapping("/notify")
//    public String notifyAllUser(){
//
//        thongBaoService.sendToAll(
//                NotificationResponse.builder()
//                        .id(UUID.randomUUID().toString())
//                        .title("Test")
//                        .message("Hello WebSocket")
//                        .type("WARN")
//                        .time(LocalDateTime.now())
//                        .build()
//        );
//
//        return "OK";
//    }
//}
