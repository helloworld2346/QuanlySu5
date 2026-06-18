package org.example.quanlysu5.Dto.Request;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.example.quanlysu5.Dto.Response.DonBaoCao.DonBaoCaoNoList;
import org.example.quanlysu5.Module.BaseEntity;
import org.example.quanlysu5.Module.DonBaoCaoEntity;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NhiemVuNgayRequest  {

    String nhiemVuPhandoi;

    String noiDungDotXuat;

    String noiDungUuDiem;

    String noiDungKhuyetDiem;

    String noiDungCanGiaiQuyet;

    String donBaoCao;
}
