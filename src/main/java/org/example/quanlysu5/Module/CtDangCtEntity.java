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
public class CtDangCtEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_congtac",columnDefinition = "VARCHAR(36) COMMENT 'Id của công tác đảng, chính trị'")
    String idCongtac;

    @Column(columnDefinition = "TEXT COMMENT 'tình hình hoạt động trong ngày'", nullable = false)
    String tinhHinh;

    @Column(columnDefinition = "TEXT COMMENT 'Nội dung đột xuất'", nullable = false)
    String noiDungDotXuat;

    @Column(columnDefinition = "TEXT COMMENT 'Kết quả'", nullable = false)
    String ketQua;

    @Column(columnDefinition = "TEXT COMMENT 'Khuyến nghị kết quả'", nullable = false)
    String khuyenNghi;

    @ManyToOne
    @JoinColumn(name = "maDonVi",nullable = false)
    DonViEntity donVi;
}
