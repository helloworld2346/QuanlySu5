package org.example.quanlysu5.Data;

import org.example.quanlysu5.Dto.Request.DonviRequest;
import org.example.quanlysu5.Enum.CapDonVi;

import java.util.List;

public class PhongBanTrucThuocSuData {
    public static List<DonviRequest> getData(String maCha) {

        return List.of(
                DonviRequest.builder()
                        .tenDonvi("Phòng tham mưu")
                        .kyhieuDonvi("ptm")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.PHONG.toString())
                        .build(),

                DonviRequest.builder()
                        .tenDonvi("Phòng chính trị")
                        .kyhieuDonvi("pct")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.PHONG.toString())
                        .build(),

                DonviRequest.builder()
                        .tenDonvi("Phòng hậu cần kỹ thuật")
                        .kyhieuDonvi("phckt")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.PHONG.toString())
                        .build()
        );
    }
}
