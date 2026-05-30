package org.example.quanlysu5.Repo;

import org.example.quanlysu5.Module.AccountEntity;
import org.example.quanlysu5.Module.FeatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeatureRepo extends JpaRepository<FeatureEntity,String> , JpaSpecificationExecutor<FeatureEntity> {
    Optional<FeatureEntity> findByFeatureName(String featureName);
}
