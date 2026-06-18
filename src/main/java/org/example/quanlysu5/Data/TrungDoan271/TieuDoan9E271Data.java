package org.example.quanlysu5.Data.TrungDoan271;

import org.example.quanlysu5.Dto.Request.DonviRequest;
import org.example.quanlysu5.Enum.CapDonVi;

import java.util.List;

public class TieuDoan9E271Data {
    public static List<DonviRequest> getData(String maCha) {

        return List.of(
                DonviRequest.builder()
                        .tenDonvi("Đại đội 9")
                        .kyhieuDonvi("c9")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Đại đội 10")
                        .kyhieuDonvi("c10")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Đại đội 11")
                        .kyhieuDonvi("c11")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Đại đội 12")
                        .kyhieuDonvi("c12")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
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
