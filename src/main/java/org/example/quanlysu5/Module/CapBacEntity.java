package org.example.quanlysu5.Module;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CapBacEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_cap_bac",columnDefinition = "VARCHAR(36) COMMENT 'Id của cấp bậc'")
    String idCapBac;

    @Column(columnDefinition = "VARCHAR(255) COMMENT 'tên cấp bậc'", nullable = false)
    String tenCapBac;

    @Column(columnDefinition = "VARCHAR(10) COMMENT 'ký hiệu cấp bậc'")
    String kyhieu;

}
