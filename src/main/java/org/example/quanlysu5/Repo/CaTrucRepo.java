package org.example.quanlysu5.Repo;

import org.example.quanlysu5.Module.CaTrucEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CaTrucRepo extends JpaRepository<CaTrucEntity, String>, JpaSpecificationExecutor<CaTrucEntity> {
    List<CaTrucEntity> findAllByIsDeleted(boolean isDeleted);
    boolean existsByNgaytruc(LocalDate ngaytruc);
    //Page<UnitsEntity> findAllbyPage(Boolean isDeleted, Pageable pageable);

}
