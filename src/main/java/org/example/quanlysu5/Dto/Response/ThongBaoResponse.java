package org.example.quanlysu5.Dto.Response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.example.quanlysu5.Enum.LoaiMuctieu;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ThongBaoResponse {
    String idThongbao;
    String tieuDe;
    String noiDung;
    String loaiThongBao;
    Boolean daDoc;
    LoaiMuctieu loaiMuctieu;
    String idMuctieu;

}
