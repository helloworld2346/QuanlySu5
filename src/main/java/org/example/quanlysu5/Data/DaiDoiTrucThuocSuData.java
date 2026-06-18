package org.example.quanlysu5.Data;

import org.example.quanlysu5.Dto.Request.DonviRequest;
import org.example.quanlysu5.Enum.CapDonVi;

import java.util.List;

public class DaiDoiTrucThuocSuData {
    public static List<DonviRequest> getData(String maCha) {

        return List.of(
                DonviRequest.builder()
                        .tenDonvi("Đại đội 19")
                        .kyhieuDonvi("c19")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build(),

                DonviRequest.builder()
                        .tenDonvi("Đại đội 20")
                        .kyhieuDonvi("c20")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build(),

                DonviRequest.builder()
                        .tenDonvi("Đại đội 23")
                        .kyhieuDonvi("c23")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build(),

                DonviRequest.builder()
                        .tenDonvi("Đại đội kho")
                        .kyhieuDonvi("cK")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build(),

                DonviRequest.builder()
                        .tenDonvi("Đại Đội Sửa Chữa")
                        .kyhieuDonvi("cSC")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build()
        );
    }
}
