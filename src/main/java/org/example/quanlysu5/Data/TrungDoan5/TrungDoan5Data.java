package org.example.quanlysu5.Data.TrungDoan5;

import org.example.quanlysu5.Dto.Request.DonviRequest;
import org.example.quanlysu5.Enum.CapDonVi;

import java.util.List;

public class TrungDoan5Data {
    public static List<DonviRequest> getData(String maCha) {

        return List.of(
                DonviRequest.builder()
                        .tenDonvi("Trung đoàn bộ")
                        .kyhieuDonvi("ebộ")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.TRUNG_DOAN.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Ban Tham mưu e5")
                        .kyhieuDonvi("BTM-e5")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.BAN.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Ban Chính trị e5")
                        .kyhieuDonvi("BCT-e5")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.BAN.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Ban Hậu cần-Kỹ thuật e5")
                        .kyhieuDonvi("BHC-KT-e5")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.BAN.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Tiểu đoàn 4 e5")
                        .kyhieuDonvi("d4-e5")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.TIEU_DOAN.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Tiểu đoàn 5 e5")
                        .kyhieuDonvi("d5-e5")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.TIEU_DOAN.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Tiểu đoàn 6 e5")
                        .kyhieuDonvi("d6-e5")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.TIEU_DOAN.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Đại đội 14")
                        .kyhieuDonvi("c14-e5")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Đại đội 15")
                        .kyhieuDonvi("c15-e5")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Đại đội 16")
                        .kyhieuDonvi("c16-e5")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Đại đội 17")
                        .kyhieuDonvi("c17-e5")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Đại đội 18")
                        .kyhieuDonvi("c18-e5")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Đại đội 20")
                        .kyhieuDonvi("c20-e5")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Đại đội 24")
                        .kyhieuDonvi("c24-e5")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Đại đội 25")
                        .kyhieuDonvi("c25-e5")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.DAI_DOI.toString())
                        .build()
        );
    }
}
