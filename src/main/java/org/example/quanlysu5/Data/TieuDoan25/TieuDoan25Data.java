package org.example.quanlysu5.Data.TieuDoan25;

import org.example.quanlysu5.Dto.Request.DonviRequest;
import org.example.quanlysu5.Enum.CapDonVi;

import java.util.List;

public class TieuDoan25Data {
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
                        .tenDonvi("Tiểu đoàn bộ")
                        .kyhieuDonvi("dbộ")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.TIEU_DOAN.toString())
                        .build()
        );
    }
}
