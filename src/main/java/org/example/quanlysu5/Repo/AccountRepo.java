package org.example.quanlysu5.Repo;

import org.example.quanlysu5.Module.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<AccountEntity,String> , JpaSpecificationExecutor<AccountEntity> {
    Optional<AccountEntity> findByAccountName(String accountName);
}
