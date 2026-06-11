package org.example.quanlysu5.Dto.Request;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.example.quanlysu5.Enum.LoaiMuctieu;
import org.example.quanlysu5.Module.BaseEntity;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ThongBaoRequest {
    String tieuDe;
    String noiDung;
    String loaiThongBao;
    String idMuctieu;

}
