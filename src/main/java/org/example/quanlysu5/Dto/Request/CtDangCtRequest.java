package org.example.quanlysu5.Dto.Request;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.example.quanlysu5.Module.BaseEntity;
import org.example.quanlysu5.Module.DonBaoCaoEntity;
import org.example.quanlysu5.Module.DonViEntity;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CtDangCtRequest {
    String idCongtac;

    String tinhHinh;

    String noiDungDotXuat;

    String ketQua;

    String khuyenNghi;

    @OneToOne
    @JoinColumn(name = "id_don_bao_cao")
    DonBaoCaoEntity donBaoCao;
    @ManyToOne
    @JoinColumn(name = "maDonVi",nullable = false)
    DonViEntity donVi;
}
