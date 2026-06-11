package org.example.quanlysu5.Repo;

import jakarta.transaction.Transactional;
import org.example.quanlysu5.Module.ThongBaoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ThongBaoRepo extends JpaRepository<ThongBaoEntity, String>, JpaSpecificationExecutor<ThongBaoEntity> {
    Page<ThongBaoEntity> findAllByDaDoc(Boolean isDeleted, Pageable pageable);
    List<ThongBaoEntity> findAllByDaDocAndIdMuctieu(boolean daDoc,String idMuctieu);
    List<ThongBaoEntity> findAllByDaDoc(boolean daDoc);
    @Transactional
    void deleteAllByIdMuctieu(String idMuctieu);
    List<ThongBaoEntity> findAllByDaDocTrueAndCreatedAtBefore(
            LocalDateTime time
    );

    void deleteAllByDaDocTrueAndCreatedAtBefore(
            LocalDateTime time
    );
    //Page<UnitsEntity> findAllbyPage(Boolean isDeleted, Pageable pageable);

}
