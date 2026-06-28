package org.example.quanlysu5.Form;

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
public class CtDangCtForm {

    String tinhHinh;

    String noiDungDotXuat;

    String ketQua;

    String khuyenNghi;

}
