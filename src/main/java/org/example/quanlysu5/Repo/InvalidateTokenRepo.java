package org.example.quanlysu5.Repo;

import org.example.quanlysu5.Module.InvalidateTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvalidateTokenRepo extends JpaRepository<InvalidateTokenEntity,String> {
}
