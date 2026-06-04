package org.example.quanlysu5.Sheduler;

import lombok.RequiredArgsConstructor;
import org.example.quanlysu5.Dto.Response.Notification.NotificationResponse;
import org.example.quanlysu5.Module.DonViEntity;
import org.example.quanlysu5.Repo.DonBaoCaoRepo;
import org.example.quanlysu5.Repo.DonViRepo;
import org.example.quanlysu5.Service.NotificationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BaoBanScheduler {

    private final NotificationService notificationService;

    private final DonViRepo donViRepo;

    private final DonBaoCaoRepo donBaoCaoRepo;

    @Scheduled(cron = "0 */5 * * * *")
    public void checkBaoBanNgay() {

        LocalDate today = LocalDate.now();

        List<DonViEntity> donVis =
                donViRepo.findAllByIsDeleted(false);

        for(DonViEntity dv : donVis){

            boolean daBaoCao =
                    donBaoCaoRepo
                            .existsByDonViAndThoiGianBaoCao(
                                    dv,
                                    today
                            );

            if(!daBaoCao){

                notificationService.sendToAll(
                        NotificationResponse.builder()
                                .title("Nhắc báo ban")
                                .message(
                                        dv.getTenDonvi()
                                                + " chưa gửi báo ban ngày"
                                )
                                .type("WARNING")
                                .time(LocalDateTime.now())
                                .build()
                );
            }
        }
    }
}
