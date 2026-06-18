package org.example.quanlysu5.Data;

import org.example.quanlysu5.Dto.Request.DonviRequest;
import org.example.quanlysu5.Enum.CapDonVi;

import java.util.List;

public class TrungDoanTrucThuocSuData {
    public static List<DonviRequest> getData(String maCha) {

        return List.of(
                DonviRequest.builder()
                        .tenDonvi("Trung đoàn 4")
                        .kyhieuDonvi("e4")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.TRUNG_DOAN.toString())
                        .build(),

                DonviRequest.builder()
                        .tenDonvi("Trung đoàn 5")
                        .kyhieuDonvi("e5")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.TRUNG_DOAN.toString())
                        .build(),

                DonviRequest.builder()
                        .tenDonvi("Trung đoàn 271")
                        .kyhieuDonvi("e271")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.TRUNG_DOAN.toString())
                        .build()
        );
    }
}
