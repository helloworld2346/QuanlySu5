package org.example.quanlysu5.Dto.Response.DonVi;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.example.quanlysu5.Enum.CapDonVi;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DonViNoList {
    String maDonVi;
    String tenDonvi;
    String kyhieuDonvi;
    CapDonVi capDonVi;
}
