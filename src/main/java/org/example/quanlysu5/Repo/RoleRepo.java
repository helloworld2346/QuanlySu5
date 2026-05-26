package org.example.quanlysu5.Repo;

import org.example.quanlysu5.Module.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<RoleEntity,String>, JpaSpecificationExecutor<RoleEntity> {
    RoleEntity findByRoleId(String RoleId);
    RoleEntity findByRoleName(String RoleName);
}
