package org.example.quanlysu5.Sheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.quanlysu5.Config.MyWebSocketHandler;
import org.example.quanlysu5.Dto.Request.ThongBaoRequest;
import org.example.quanlysu5.Module.DonBaoCaoEntity;
import org.example.quanlysu5.Module.DonViEntity;
import org.example.quanlysu5.Module.KhungGioBaoCaoEntity;
import org.example.quanlysu5.Module.ThongBaoEntity;
import org.example.quanlysu5.Repo.DonBaoCaoRepo;
import org.example.quanlysu5.Repo.DonViRepo;
import org.example.quanlysu5.Repo.KhungGioBaoCaoRepo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class BaoBanScheduler {

    private  final MyWebSocketHandler myWebSocketHandler;

    private final DonViRepo donViRepo;

    private final DonBaoCaoRepo donBaoCaoRepo;

    private final KhungGioBaoCaoRepo khungGioBaoCaoRepo;

    @Scheduled(cron = "0 */15 * * * *")
    public void checkBaoBanNgay() {
        log.warn("hehehehehehe");
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.atTime(23, 59, 59);

        List<DonViEntity> donVis =
                donViRepo.findAllByIsDeleted(false);

        for(DonViEntity dv : donVis){

            boolean daBaoCao =
                    donBaoCaoRepo
                            .existsByDonViAndThoiGianBaoCaoBetween(
                                    dv,
                                    startOfDay,endOfDay
                            );

            if(!daBaoCao){
                // Tạo chuỗi JSON thủ công hoặc dùng ObjectMapper để chuyển đổi Object thành String
                String jsonMessage = String.format(
                        "{\"title\":\"Nhắc báo ban\",\"message\":\"%s chưa gửi báo ban ngày\",\"type\":\"WARNING\"}",
                        dv.getTenDonvi()
                );
                log.warn("Đơn vị "+dv.getMaDonVi());
                ThongBaoRequest thongBaoRequest=ThongBaoRequest.builder()
                        .loaiThongBao("WARNING")
                        .idMuctieu(dv.getMaDonVi())
                        .noiDung(dv.getTenDonvi()+" chưa gửi báo ban ngày")
                        .tieuDe("Nhắc báo ban")
                        .build();

                // Bắn tin nhắn thuần đi
                myWebSocketHandler.sendToDonVi(dv.getMaDonVi(),jsonMessage,thongBaoRequest);
            }
        }

        //checkChuaDuyetDenCapGS003(startOfDay, endOfDay);
        checkSapToiHanNop(today);
    }


    private void checkSapToiHanNop(LocalDate today) {

        List<KhungGioBaoCaoEntity> khungGioList =
                khungGioBaoCaoRepo.findAllByIsDeleted(false);

        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.atTime(23, 59, 59);

        LocalTime now = LocalTime.now();

        for (KhungGioBaoCaoEntity khungGio : khungGioList) {

            LocalTime deadline = khungGio.getKhunggioKetthuc();

            if (deadline == null) {
                continue;
            }

            // Trước hạn 1 giờ
            if (
                    now.isAfter(deadline.minusHours(1))
                            && now.isBefore(deadline)
            ) {

                List<DonViEntity> donVis =
                        donViRepo.findAllByIsDeleted(false);

                for (DonViEntity dv : donVis) {

                    boolean daBaoCao =
                            donBaoCaoRepo.existsByDonViAndThoiGianBaoCaoBetween(
                                    dv,
                                    startOfDay,
                                    endOfDay
                            );

                    if (!daBaoCao) {

                        String jsonMessage = String.format(
                                "{\"title\":\"Sắp tới hạn nộp\",\"message\":\"%s sắp tới hạn nộp báo cáo %s\",\"type\":\"URGENT\"}",
                                dv.getTenDonvi(),
                                khungGio.getTenBaocao()
                        );
                        log.warn("Mã đơn vị "+dv.getTenDonvi());
                        ThongBaoRequest thongBaoRequest=ThongBaoRequest.builder()
                                .loaiThongBao("URGENT")
                                .idMuctieu(dv.getMaDonVi())
                                .noiDung("Đơn vị "+dv.getTenDonvi()+" sắp tới hạn nộp báo cáo")
                                .tieuDe("Sắp tới hạn nộp")
                                .build();

                        myWebSocketHandler.sendToDonVi(dv.getMaDonVi(),jsonMessage,thongBaoRequest);
                    }
                }
            }
        }
    }
}
