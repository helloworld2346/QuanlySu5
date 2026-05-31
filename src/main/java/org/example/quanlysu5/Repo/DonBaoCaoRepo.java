package org.example.quanlysu5.Repo;

import org.example.quanlysu5.Module.DonBaoCaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface DonBaoCaoRepo extends JpaRepository<DonBaoCaoEntity,String>, JpaSpecificationExecutor<DonBaoCaoEntity> {
    Optional<DonBaoCaoEntity> findAllByIsDeleted(boolean isDeleted);
}
