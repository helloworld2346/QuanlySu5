package org.example.quanlysu5.Repo;

import org.example.quanlysu5.Module.VaiTroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VaiTroRepo extends JpaRepository<VaiTroEntity,String>, JpaSpecificationExecutor<VaiTroEntity> {
    VaiTroEntity findByidVaiTro(String idVaiTro);
    Optional<VaiTroEntity> findByTenVaiTro(String RoleName);
}
