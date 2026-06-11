package org.example.quanlysu5.Repo;

import org.example.quanlysu5.Module.LyDoVangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LyDoVangRepo extends JpaRepository<LyDoVangEntity, String>, JpaSpecificationExecutor<LyDoVangEntity> {
}
