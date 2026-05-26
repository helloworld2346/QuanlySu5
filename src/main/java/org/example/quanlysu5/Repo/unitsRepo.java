package org.example.quanlysu5.Repo;

import org.example.quanlysu5.Module.units;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface unitsRepo extends JpaRepository<units, String>, JpaSpecificationExecutor<units> {
    Page<units> findAllByIsDeleted(Boolean isDeleted,Pageable pageable);
    Page<units> findAll(Boolean isDeleted,Pageable pageable);

}
