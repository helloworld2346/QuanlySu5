package org.example.quanlysu5.Config;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.example.quanlysu5.Module.DonViEntity;
import org.example.quanlysu5.Module.TaikhoanEntity;
import org.example.quanlysu5.Module.VaiTroEntity;
import org.example.quanlysu5.Repo.AccountRepo;
import org.example.quanlysu5.Repo.DonViRepo;
import org.example.quanlysu5.Repo.VaiTroRepo;
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
    ApplicationRunner applicationRunner(AccountRepo accountRepository, VaiTroRepo vaiTroRepository, AccountRepo accountRepo,
                                        DonViRepo donViRepo){
        return args -> {
            // Initial data setup
            if(accountRepository.findByTenTaiKhoan("admin").isEmpty()) {

                VaiTroEntity roleAdmin = VaiTroEntity.builder()
                        .tenVaiTro("Ban Thông tin")
                        .isDeleted(false)
                        .tenChucnang(new HashSet<>(
                                Arrays.asList("Báo Ban", "Thống Kê")
                        ))
                        .build();
                        vaiTroRepository.save(roleAdmin);


                TaikhoanEntity user= TaikhoanEntity.builder()
                        .tenTaiKhoan("admin")
                        .tenDangNhap("admin")
                        .matKhau(passwordEncoder.encode("admin"))
                        .createdAt(LocalDateTime.now())
                        .vaiTro(roleAdmin)
                        .isDeleted(false)
                        .build();
                DonViEntity donviEntity=DonViEntity.builder()
                        .tenDonvi("Sư 5")
                        .hoatDong(true)
                        .maDonVi("GS003")
                        .quanSoTong(0)
                        .quanSoHsqBs(0)
                        .quanSoSiQuan(0)
                        .quanSoQncn(0)
                        .isDeleted(false)
                        .build();

                donViRepo.save(donviEntity);
                user.setDonVi(donviEntity);
                accountRepo.save(user);
            }

            log.warn("user admin created with default password username is admin");
        };
    }
}
