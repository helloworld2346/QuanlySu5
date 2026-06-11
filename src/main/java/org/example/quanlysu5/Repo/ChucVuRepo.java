package org.example.quanlysu5.Repo;

import org.example.quanlysu5.Module.ChucVuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChucVuRepo extends JpaRepository<ChucVuEntity, String>, JpaSpecificationExecutor<ChucVuEntity> {
    Optional<ChucVuEntity> findByTenChucVu(String tenChucVu);
}
