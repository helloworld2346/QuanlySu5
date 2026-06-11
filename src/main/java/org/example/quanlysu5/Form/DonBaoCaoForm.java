package org.example.quanlysu5.Form;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DonBaoCaoForm {
    Integer quanSoTong;
    Integer quanSoHienDien;
    Integer quanSoVang;
    LocalDateTime thoiGianBaoCao;
    String  thongTinVang;
    String trucBanChiHuy;
    String trucBanTacChien;
    String  chiTietVang;
    String account;
    //ca trực dựa trên thời gian báo cáo phiếu báo cáo mà tìm đc ca trực
    String donVi;
}
