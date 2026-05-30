package org.example.quanlysu5.Module;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.awt.*;
import java.time.LocalDateTime;

@Entity
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DonBaoCaoEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_don_bao_cao",columnDefinition = "VARCHAR(36) COMMENT 'Id của đơn báo cáo'")
    String idDonBaoCao;

    @Column(name = "quan_so_tong",columnDefinition = "INTEGER COMMENT 'tổng quân số'")
    Integer quanSoTong;

    @Column(name = "quan_so_hien_dien",columnDefinition = "INTEGER COMMENT 'hiện diện '")
    Integer quanSoHienDien;

    @Column(name = "quan_so_vang",columnDefinition = "INTEGER COMMENT 'tổng vắng'")
    Integer quanSoVang;

    @Column(name = "thoi_gian_bao_cao", columnDefinition = "DATETIME COMMENT 'thời gian báo cáo'")
    LocalDateTime thoiGianBaoCao;

    @Column(name = "thong_tin_vang", columnDefinition = "TEXT COMMENT 'thông tin vắng'")
    String  thongTinVang;

    @ManyToOne
    @JoinColumn(name = "accountId",nullable = false)
    TaikhoanEntity account;

    @ManyToOne
    @JoinColumn(name = "idCatruc",nullable = false)
    CaTrucEntity caTruc;

    @ManyToOne
    @JoinColumn(name = "idDonVi",nullable = false)
    DonViEntity donVi;


}
