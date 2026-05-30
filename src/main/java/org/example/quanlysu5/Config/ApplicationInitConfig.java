package org.example.quanlysu5.Config;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.example.quanlysu5.Dto.Response.AccountResponse;
import org.example.quanlysu5.Module.AccountEntity;
import org.example.quanlysu5.Module.FeatureEntity;
import org.example.quanlysu5.Module.RoleEntity;
import org.example.quanlysu5.Repo.AccountRepo;
import org.example.quanlysu5.Repo.FeatureRepo;
import org.example.quanlysu5.Repo.RoleRepo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.HashSet;

@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class ApplicationInitConfig {
    PasswordEncoder passwordEncoder;
    @Bean
    ApplicationRunner applicationRunner(AccountRepo accountRepository, RoleRepo roleRepository, AccountRepo accountRepo,
                                        FeatureRepo featureRepo){
        return args -> {
            // Initial data setup
            if(accountRepository.findByAccountName("admin").isEmpty()) {

                FeatureEntity featureThongKe=featureRepo.save(FeatureEntity.builder()
                        .featureName("Thống Kê")
                        .isDeleted(false)
                        .build());
                FeatureEntity featureBaoBan=featureRepo.save(FeatureEntity.builder()
                        .featureName("Báo Ban")
                        .isDeleted(false)
                        .build());

                RoleEntity roleAdmin = RoleEntity.builder()
                        .roleName("Ban Thông tin")
                        .isDeleted(false)
                        .build();
                roleAdmin.setFeatures(new HashSet<>());
                roleAdmin.getFeatures().add(featureThongKe);
                roleAdmin.getFeatures().add(featureBaoBan);
                        roleRepository.save(roleAdmin);


                AccountEntity user=AccountEntity.builder()
                        .accountName("admin")
                        .userName("admin")
                        .password(passwordEncoder.encode("admin"))
                        .createdAt(LocalDateTime.now())
                        .role(roleAdmin)
                        .isDeleted(false)
                        .build();

                accountRepo.save(user);
            }

            log.warn("user admin created with default password username is admin");
        };
    }
}
