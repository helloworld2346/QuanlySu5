package org.example.quanlysu5.Dto.Request;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.example.quanlysu5.Module.BaseEntity;
import org.example.quanlysu5.Module.CaTrucEntity;

import java.util.List;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TrucBanTacChienRequest extends BaseEntity {
    String tenNguoitruc;
    String capbacNguoitruc;
    String chucvuNguoitruc;
    String sodienthoai;
}
