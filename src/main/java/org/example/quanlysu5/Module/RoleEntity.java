package org.example.quanlysu5.Module;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "roleId",columnDefinition = "VARCHAR(36) COMMENT 'Id của row quyền'")
    String roleId;

    @Column(name = "role_name",columnDefinition = "VARCHAR(36) COMMENT 'tên quyền'")
    String roleName;
    @ManyToMany
    @JoinTable(
            name = "role_feature",
            joinColumns = @JoinColumn(name = "roleId"),
            inverseJoinColumns = @JoinColumn(name = "featureId")
    )
    Set<FeatureEntity> features = new HashSet<>();

    @OneToMany(mappedBy="role")
    List<AccountEntity> accounts;
}
