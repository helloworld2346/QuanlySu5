package org.example.quanlysu5.Dto.Request;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.example.quanlysu5.Dto.Response.TrucBanTacChienResponse;
import org.example.quanlysu5.Dto.Response.TrucChiHuyResponse;
import org.example.quanlysu5.Module.BaseEntity;
import org.example.quanlysu5.Module.DonBaoCaoEntity;
import org.example.quanlysu5.Module.TrucBanTacChienEntity;
import org.example.quanlysu5.Module.TrucChiHuyEntity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CaTrucRequest extends BaseEntity {

    LocalDate ngaytruc;

    String matkhau;

    String ghichu;

    String trucBanTacChien;

    String trucChiHuy;

}
