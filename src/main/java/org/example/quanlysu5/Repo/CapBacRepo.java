package org.example.quanlysu5.Repo;

import org.example.quanlysu5.Module.CapBacEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface CapBacRepo extends JpaRepository<CapBacEntity, String>, JpaSpecificationExecutor<CapBacEntity> {
    Optional<CapBacEntity> findByTenCapBac(String tenCapBac);
}
