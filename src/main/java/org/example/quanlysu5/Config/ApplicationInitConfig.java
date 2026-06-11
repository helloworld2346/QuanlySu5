package org.example.quanlysu5.Config;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.example.quanlysu5.Dto.Request.DonviRequest;
import org.example.quanlysu5.Dto.Response.DonVi.DonViResponse;
import org.example.quanlysu5.Module.DonViEntity;
import org.example.quanlysu5.Module.TaikhoanEntity;
import org.example.quanlysu5.Module.VaiTroEntity;
import org.example.quanlysu5.Repo.TaiKhoanRepo;
import org.example.quanlysu5.Repo.DonViRepo;
import org.example.quanlysu5.Repo.VaiTroRepo;
import org.example.quanlysu5.Service.DonViService;
import org.example.quanlysu5.Service.VaiTroService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class ApplicationInitConfig {
    PasswordEncoder passwordEncoder;
    @Bean
    ApplicationRunner applicationRunner(TaiKhoanRepo taiKhoanRepository, VaiTroRepo vaiTroRepository, TaiKhoanRepo taiKhoanRepo,
                                        DonViRepo donViRepo, DonViService donViService, VaiTroService vaiTroService){
        return args -> {
            // Initial data setup
            if(taiKhoanRepository.findByTenDangNhap("admin").isEmpty()) {

                VaiTroEntity vaiTro =
                        vaiTroRepository.findByTenVaiTro("Quản Trị Viên")
                                .orElseGet(() -> {

                                    VaiTroEntity role = VaiTroEntity.builder()
                                            .tenVaiTro("Quản Trị Viên")
                                            .isDeleted(false)
                                            .tenChucnang(new HashSet<>(
                                                    Arrays.asList("Báo Ban", "Thống Kê")
                                            ))
                                            .build();

                                    return vaiTroRepository.save(role);
                                });

                TaikhoanEntity user= TaikhoanEntity.builder()
                        .tenTaiKhoan("admin")
                        .tenDangNhap("admin")
                        .matKhau(passwordEncoder.encode("admin"))
                        .createdAt(LocalDateTime.now())
                        .vaiTro(vaiTro)
                        .isDeleted(false)
                        .build();
                DonViEntity Su5 = DonViEntity.builder()
                        .tenDonvi("Sư 5")
                        .hoatDong(true)
                        .kyhieuDonvi("CH/f")
                        .maDonVi("GS003")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .build();

                donViRepo.save(Su5);

                DonViResponse BanThamMuu= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Phòng Tham Mưu")
                        .kyhieuDonvi("PTM")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(Su5.getMaDonVi())
                        .build());
                DonViResponse PhongChinhTri= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Phòng Chính Trị")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                                .kyhieuDonvi("PCT")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(Su5.getMaDonVi())
                        .build());
                DonViResponse PhongHauCanKyThuat= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Phòng Hậu Cần Kỹ Thuật")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("PHC-KT")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(Su5.getMaDonVi())
                        .build());
                DonViResponse TieuDoan14= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Tiểu Đoàn 14")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("d14")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(Su5.getMaDonVi())
                        .build());
                DonViResponse TieuDoan15= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Tiểu Đoàn 15")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("d15")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(Su5.getMaDonVi())
                        .build());
                DonViResponse TieuDoan16= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Tiểu Đoàn 16")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("d16")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(Su5.getMaDonVi())
                        .build());
                DonViResponse TieuDoan17= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Tiểu Đoàn 17")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("d17")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(Su5.getMaDonVi())
                        .build());
                DonViResponse TieuDoan18= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Tiểu Đoàn 18")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("d18")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(Su5.getMaDonVi())
                        .build());
                DonViResponse TieuDoan24= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Tiểu Đoàn 24")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("d24")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(Su5.getMaDonVi())
                        .build());
                DonViResponse TieuDoan25= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Tiểu Đoàn 25")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("d25")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(Su5.getMaDonVi())
                        .build());
                DonViResponse TrungDoan4= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Trung Đoàn 4")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("e4")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(Su5.getMaDonVi())
                        .build());
                DonViResponse TrungDoan5= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Trung Đoàn 5")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("e5")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(Su5.getMaDonVi())
                        .build());
                DonViResponse TrungDoan271= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Trung Đoàn 271")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("e271")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(Su5.getMaDonVi())
                        .build());
                DonViResponse DaiDoi19= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Đại Đội 19")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("c19")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(Su5.getMaDonVi())
                        .build());
                DonViResponse DaiDoi20= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Đại Đội 20")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("c20")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(Su5.getMaDonVi())
                        .build());
                DonViResponse DaiDoi23= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Đại Đội 23")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("c23")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(Su5.getMaDonVi())
                        .build());
                DonViResponse DaiDoiSuaChua= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Đại Đội Sửa Chữa")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("cSC")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(Su5.getMaDonVi())
                        .build());
                DonViResponse DaiDoiKho= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Đại Đội Kho")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("cK")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(Su5.getMaDonVi())
                        .build());
                DonViResponse BanThamMuuE4= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Ban Tham Mưu e4")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("BTM-e4")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(TrungDoan4.getMaDonVi())
                        .build());
                DonViResponse BanChinhTriE4= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Ban Chính Trị e4")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("BCT-e4")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(TrungDoan4.getMaDonVi())
                        .build());
                DonViResponse BanHauCanKyThuatE4= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Ban Hậu Cần Kỹ Thuật e4")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("BHK-KT-e4")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(TrungDoan4.getMaDonVi())
                        .build());
                DonViResponse TieuDoanTrucThuoc1E4= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Tiểu đoàn 1 e4")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("d1-e4")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(TrungDoan4.getMaDonVi())
                        .build());
                DonViResponse TieuDoanTrucThuoc2E4= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Tiểu đoàn 2 e4")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("d2-e4")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(TrungDoan4.getMaDonVi())
                        .build());
                DonViResponse TieuDoanTrucThuoc3E4= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Tiểu đoàn 3 e4")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("d3-e4")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(TrungDoan4.getMaDonVi())
                        .build());
                DonViResponse BanThamMuuE271= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Ban Tham Mưu e271")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("BTM-e271")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(TrungDoan271.getMaDonVi())
                        .build());
                DonViResponse BanChinhTriE271= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Ban Chính Trị e271")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("BCT-e271")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(TrungDoan271.getMaDonVi())
                        .build());
                DonViResponse BanHauCanKyThuatE271= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Ban Hậu Cần Kỹ Thuật e271")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("BHK-KT-e271")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(TrungDoan271.getMaDonVi())
                        .build());
                DonViResponse TieuDoanTrucThuoc4E271= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Tiểu đoàn 4 e271")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("d4-e271")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(TrungDoan271.getMaDonVi())
                        .build());
                DonViResponse TieuDoanTrucThuoc5E271= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Tiểu đoàn 5 e271")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("d5-e271")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(TrungDoan271.getMaDonVi())
                        .build());
                DonViResponse TieuDoanTrucThuoc6E271= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Tiểu đoàn 6 e271")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("d6-e271")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(TrungDoan271.getMaDonVi())
                        .build());
                DonViResponse BanThamMuuE5= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Ban Tham Mưu e5")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("BTM-e5")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(TrungDoan5.getMaDonVi())
                        .build());
                DonViResponse BanChinhTriE5= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Ban Chính Trị e5")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("BCT-e5")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(TrungDoan5.getMaDonVi())
                        .build());
                DonViResponse BanHauCanKyThuatE5= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Ban Hậu Cần Kỹ Thuật e5")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("BHK-KT-e5")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(TrungDoan5.getMaDonVi())
                        .build());
                DonViResponse TieuDoanTrucThuoc7E5= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Tiểu đoàn 7 e5")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("d7-e5")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(TrungDoan5.getMaDonVi())
                        .build());
                DonViResponse TieuDoanTrucThuoc8E5= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Tiểu đoàn 8 e5")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("d8-e5")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(TrungDoan5.getMaDonVi())
                        .build());
                DonViResponse TieuDoanTrucThuoc9E5= donViService.createDonVi(DonviRequest.builder()
                        .tenDonvi("Tiểu đoàn 9 e5")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .kyhieuDonvi("d9-e5")
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .donViCha(TrungDoan5.getMaDonVi())
                        .build());
                user.setDonVi(Su5);
                taiKhoanRepo.save(user);
            }

            log.warn("user admin created with default password username is admin");
        };
    }
}
