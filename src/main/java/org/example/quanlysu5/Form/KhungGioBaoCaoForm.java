package org.example.quanlysu5.Form;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.LocalTime;
import java.util.Date;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KhungGioBaoCaoForm {
    String tenBaocao;
    LocalTime khunggioBatdau;
    LocalTime khunggioKetthuc;
}
