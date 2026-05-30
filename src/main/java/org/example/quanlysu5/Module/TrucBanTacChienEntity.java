package org.example.quanlysu5.Module;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TrucBanTacChienEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_nguoitruc",columnDefinition = "VARCHAR(36) COMMENT 'Id của người trực ban tác chiên'")
    String idNguoitruc;

    @Column(name = "ten_nguoitruc",columnDefinition = "VARCHAR(255) COMMENT 'tên người trực ban tác chiên'")
    String tenNguoitruc;

    @Column(name = "capbac_nguoitruc",columnDefinition = "VARCHAR(255) COMMENT 'cấp bậc người trực ban tác chiên'")
    String capbacNguoitruc;

    @Column(name = "chucvu_nguoitruc",columnDefinition = "VARCHAR(255) COMMENT 'chức vụ người trực ban tác chiên'")
    String chucvuNguoitruc;

    @Column(name = "sodienthoai",columnDefinition = "VARCHAR(10) COMMENT 'dien thoại người trực ban tác chiên'")
    String sodienthoai;

    @OneToMany(mappedBy = "trucBanTacChien")
    List<CaTrucEntity> caTruc;
}
