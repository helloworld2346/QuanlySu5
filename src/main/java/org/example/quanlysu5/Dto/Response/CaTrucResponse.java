package org.example.quanlysu5.Dto.Response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.example.quanlysu5.Module.BaseEntity;
import org.example.quanlysu5.Module.DonBaoCaoEntity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CaTrucResponse extends BaseEntity {

    String idCatruc;

    LocalDate ngaytruc;

    String matkhau;

    String ghichu;

    TrucBanTacChienResponse trucBanTacChien;

    TrucChiHuyResponse trucChiHuy;

    List<DonBaoCaoEntity> donBaoCao;

}
