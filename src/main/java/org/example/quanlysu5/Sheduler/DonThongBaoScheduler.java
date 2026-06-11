package org.example.quanlysu5.Sheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.quanlysu5.Dto.Response.ThongBaoResponse;
import org.example.quanlysu5.Module.ThongBaoEntity;
import org.example.quanlysu5.Service.ThongBaoService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DonThongBaoScheduler {
    private  final ThongBaoService thongBaoService;
    @Scheduled(cron = "0 0 0 * * *")
    public void donThongBao() {

        log.warn("Bắt đầu dọn thông báo cũ");

        thongBaoService.deleteThongBaoDaDocQuaHan();

        log.warn("Dọn thông báo thành công");
    }
}
