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
public class ChucVuEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_chuc_vu",columnDefinition = "VARCHAR(36) COMMENT 'Id của chuc vu'")
    String idChucVu;

    @Column(columnDefinition = "VARCHAR(255) COMMENT 'tên chức vụ'", nullable = false)
    String tenChucVu;

    @Column(columnDefinition = "VARCHAR(255) COMMENT 'mô tả'")
    String mota;

}
