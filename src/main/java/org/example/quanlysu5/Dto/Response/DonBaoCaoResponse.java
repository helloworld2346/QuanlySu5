package org.example.quanlysu5.Dto.Response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.example.quanlysu5.Module.CaTrucEntity;
import org.example.quanlysu5.Module.DonViEntity;
import org.example.quanlysu5.Module.TaikhoanEntity;

import java.time.LocalDateTime;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DonBaoCaoResponse {
    String idDonBaoCao;
    Integer quanSoTong;
    Integer quanSoHienDien;
    Integer quanSoVang;
    LocalDateTime thoiGianBaoCao;
    String  thongTinVang;
    TaikhoanEntity account;
    CaTrucEntity caTruc;
    DonViEntity donVi;


}
