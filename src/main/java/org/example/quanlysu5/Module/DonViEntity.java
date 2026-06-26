package org.example.quanlysu5.Module;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.example.quanlysu5.Enum.CapDonVi;

import java.util.List;

@Entity
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DonViEntity extends BaseEntity{
    @Id
    @Column(unique = true, nullable = false)
    String maDonVi;

    @Column(columnDefinition = "VARCHAR(255) COMMENT 'tên đơn vị'", nullable = false)
    String tenDonvi;

    @Column(columnDefinition = "VARCHAR(25) COMMENT 'ký hiệu đơn vị'", nullable = false)
    String kyhieuDonvi;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "cap_don_vi",
            columnDefinition = "VARCHAR(30) COMMENT 'Cấp đơn vị'",
            nullable = false
    )
    CapDonVi capDonVi;

    @Column(columnDefinition = "INTEGER COMMENT 'Tổng quân số trong đơn vị đó'",nullable = false)
    @Builder.Default
    Integer quanSoTong=0;

    @Column(columnDefinition = "INTEGER COMMENT 'Quân số hạ sĩ quan binh sĩ'",nullable = false)
    @Builder.Default
    Integer quanSoHsqBs=0;

    @Column(columnDefinition = "INTEGER COMMENT 'Quân số si quan đơn vị đó'",nullable = false)
    @Builder.Default
    Integer quanSoSiQuan=0;

    @Column(columnDefinition = "INTEGER COMMENT 'Quân số QNCN trong đơn vị đó'",nullable = false)
    @Builder.Default
    Integer quanSoQncn=0;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_don_vi_cha")
    DonViEntity donViCha;

    @OneToMany(mappedBy = "donViCha")
    List<DonViEntity> donViCon;
    @Column(columnDefinition = "BOOLEAN  COMMENT 'trạng thái hoạt động'",nullable = false)
    Boolean hoatDong;

    @OneToMany(mappedBy = "donVi")
    List<TaikhoanEntity> taiKhoan;

    @OneToMany(mappedBy = "donVi")
    List<DonBaoCaoEntity> donBaoCao;

    @OneToMany(mappedBy = "donVi")
    List<CtDangCtEntity> CtDangCt;
}
