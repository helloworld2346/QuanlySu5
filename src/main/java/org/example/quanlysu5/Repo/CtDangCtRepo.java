package org.example.quanlysu5.Repo;

import org.example.quanlysu5.Module.CtDangCtEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CtDangCtRepo extends JpaRepository<CtDangCtEntity,String> {
    Optional<CtDangCtEntity> findByDonVi_MaDonVi(String maDonVi);
}
