package org.example.quanlysu5.Data.TrungDoan271;

import org.example.quanlysu5.Dto.Request.DonviRequest;
import org.example.quanlysu5.Enum.CapDonVi;

import java.util.List;

public class TieuDoan7E271Data {
    public static List<DonviRequest> getData(String maCha) {

        return List.of(
                DonviRequest.builder()
                        .tenDonvi("Đại đội 1")
                        .kyhieuDonvi("c1")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Đại đội 2")
                        .kyhieuDonvi("c2")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Đại đội 3")
                        .kyhieuDonvi("c3")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Đại đội 4")
                        .kyhieuDonvi("c4")
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
