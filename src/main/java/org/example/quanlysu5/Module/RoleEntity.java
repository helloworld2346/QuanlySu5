package org.example.quanlysu5.Module;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class RoleEntity {

    @Column(name = "id")
    String id;

    @Column(name = "role_name")
    String roleName;

}
