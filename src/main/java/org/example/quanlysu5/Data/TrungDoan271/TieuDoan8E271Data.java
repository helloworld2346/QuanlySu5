package org.example.quanlysu5.Data.TrungDoan271;

import org.example.quanlysu5.Dto.Request.DonviRequest;
import org.example.quanlysu5.Enum.CapDonVi;

import java.util.List;

public class TieuDoan8E271Data {
    public static List<DonviRequest> getData(String maCha) {

        return List.of(
                DonviRequest.builder()
                        .tenDonvi("Đại đội 5")
                        .kyhieuDonvi("c5")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Đại đội 6")
                        .kyhieuDonvi("c6")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Đại đội 7")
                        .kyhieuDonvi("c7")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Đại đội 8")
                        .kyhieuDonvi("c8")
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .donViCha(maCha)
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Khối TT,dbộ")
                        .kyhieuDonvi("dbộ")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.TIEU_DOAN.toString())
                        .build()
        );
    }
}
