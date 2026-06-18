package org.example.quanlysu5.Dto.Response.NhiemvuNgay;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NhiemVuNgayResponse {
    String idNhiemvuNgay;

    String nhiemVuPhandoi;

    String noiDungDotXuat;

    String noiDungUuDiem;

    String noiDungKhuyetDiem;

    String noiDungCanGiaiQuyet;

}
