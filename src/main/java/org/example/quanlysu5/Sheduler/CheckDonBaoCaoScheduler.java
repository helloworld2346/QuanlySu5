//package org.example.quanlysu5.Sheduler;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.example.quanlysu5.Config.MyWebSocketHandler;
//import org.example.quanlysu5.Enum.LoaiBaoBan;
//import org.example.quanlysu5.Exception.AppException;
//import org.example.quanlysu5.Exception.ErrorCode;
//import org.example.quanlysu5.Module.DonViEntity;
//import org.example.quanlysu5.Module.KhungGioBaoCaoEntity;
//import org.example.quanlysu5.Repo.DonBaoCaoRepo;
//import org.example.quanlysu5.Repo.DonViRepo;
//import org.example.quanlysu5.Repo.KhungGioBaoCaoRepo;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//@Slf4j
//public class CheckDonBaoCaoScheduler {
//    private final DonBaoCaoRepo donBaoCaoRepo;
//    private final DonViRepo donViRepo;
//    private final KhungGioBaoCaoRepo khungGioBaoCaoRepo;
//    private final MyWebSocketHandler myWebSocketHandler;
//
//    @Scheduled(cron = "0 */30 * * * *")
//    public void checkDonViChuaNopBaoBan(){
//        KhungGioBaoCaoEntity khungGioBaoCaoEntity=khungGioBaoCaoRepo
//                .findByLoaiBaoBan(LoaiBaoBan.BAOBAN_NGAY).orElseThrow(()->new AppException(ErrorCode.KHUNGGIOBAOCAO_NOT_FOUND));
//        LocalTime now=LocalTime.now();
//        if(now.isAfter(khungGioBaoCaoEntity.getKhunggioKetthuc().minusHours(14))){
//            List<DonViEntity> listDonVi=donViRepo.findAllByIsDeleted(false);
//            LocalTime localTimeStart = khungGioBaoCaoEntity.getKhunggioBatdau();
//            LocalTime localTimeEnd = khungGioBaoCaoEntity.getKhunggioKetthuc();
//
//
//            LocalDateTime start =
//                    localTimeStart.atDate(LocalDate.now());
//            LocalDateTime end=
//                    localTimeEnd.atDate(LocalDate.now());
//            for(DonViEntity dv:listDonVi){
//                boolean exsistDonBaoCao=donBaoCaoRepo.existsByDonViAndThoiGianBaoCaoBetween(dv,start,end);
//                if(!exsistDonBaoCao){
//                    String jsonMessage = String.format(
//                            "{\"title\":\"Sắp tới hạn nộp\",\"message\":\"%s sắp tới hạn nộp báo cáo %s\",\"type\":\"URGENT\"}",
//                            dv.getTenDonvi(),
//                            khungGioBaoCaoEntity.getTenBaocao()
//                    );
//                    log.warn(jsonMessage);
//
//                    myWebSocketHandler.sendToDonVi(dv.getMaDonVi(),jsonMessage);
//                }
//            }
//        }
//
//    }
//}
