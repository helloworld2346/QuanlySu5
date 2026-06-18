package org.example.quanlysu5.Data.TrungDoan4;

import org.example.quanlysu5.Dto.Request.DonviRequest;
import org.example.quanlysu5.Enum.CapDonVi;

import java.util.List;

public class TrungDoan4Data {
    public static List<DonviRequest> getData(String maCha) {

        return List.of(
                DonviRequest.builder()
                        .tenDonvi("Trung đoàn bộ")
                        .kyhieuDonvi("ebộ")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.TRUNG_DOAN.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Ban Tham mưu e4")
                        .kyhieuDonvi("BTM-e4")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.BAN.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Ban Chính trị e4")
                        .kyhieuDonvi("BCT-e4")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.BAN.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Ban Hậu cần-Kỹ Thuật e4")
                        .kyhieuDonvi("BHC-KT-e4")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.BAN.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Tiểu đoàn 1 e4")
                        .kyhieuDonvi("d1-e4")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.TIEU_DOAN.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Tiểu đoàn 2 e4")
                        .kyhieuDonvi("d2-e4")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.TIEU_DOAN.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Tiểu đoàn 3 e4")
                        .kyhieuDonvi("d3-e4")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.TIEU_DOAN.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Đại đội 14")
                        .kyhieuDonvi("c14-e4")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Đại đội 15")
                        .kyhieuDonvi("c15-e4")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Đại đội 16")
                        .kyhieuDonvi("c16-e4")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Đại đội 17")
                        .kyhieuDonvi("c17-e4")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Đại đội 18")
                        .kyhieuDonvi("c18-e4")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Đại đội 20")
                        .kyhieuDonvi("c20-e4")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Đại đội 24")
                        .kyhieuDonvi("c24-e4")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Đại đội 25")
                        .kyhieuDonvi("c25-e4")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build()
        );
    }
}
