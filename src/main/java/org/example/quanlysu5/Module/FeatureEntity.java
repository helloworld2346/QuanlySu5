package org.example.quanlysu5.Module;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FeatureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "featureId",columnDefinition = "VARCHAR(36) COMMENT `Id của row chức năng`")
    String featureId;

    @Column(name = "featureName",columnDefinition = "VARCHAR(255) COMMENT 'tên chức năng'", nullable = false)
    String featureName;
    @ManyToMany(mappedBy = "features")
    Set<RoleEntity> roles = new HashSet<>();

}
