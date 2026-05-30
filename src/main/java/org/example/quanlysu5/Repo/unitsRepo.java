package org.example.quanlysu5.Repo;

import org.example.quanlysu5.Module.UnitsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface unitsRepo extends JpaRepository<UnitsEntity, String>, JpaSpecificationExecutor<UnitsEntity> {
    Page<UnitsEntity> findAllByIsDeleted(Boolean isDeleted, Pageable pageable);
    //Page<UnitsEntity> findAllbyPage(Boolean isDeleted, Pageable pageable);

}
