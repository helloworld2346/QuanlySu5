package org.example.quanlysu5.Data;

import org.example.quanlysu5.Dto.Request.DonviRequest;
import org.example.quanlysu5.Enum.CapDonVi;

import java.util.List;

public class TieuDoanTrucThuocSuData {
    public static List<DonviRequest> getData(String maCha) {

        return List.of(
                DonviRequest.builder()
                        .tenDonvi("Tiểu đoàn 14")
                        .kyhieuDonvi("d14")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.TIEU_DOAN.toString())
                        .build(),

                DonviRequest.builder()
                        .tenDonvi("Tiểu đoàn 15")
                        .kyhieuDonvi("d15")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.TIEU_DOAN.toString())
                        .build(),

                DonviRequest.builder()
                        .tenDonvi("Tiểu đoàn 16")
                        .kyhieuDonvi("d16")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.TIEU_DOAN.toString())
                        .build(),

                DonviRequest.builder()
                        .tenDonvi("Tiểu đoàn 17")
                        .kyhieuDonvi("d17")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.TIEU_DOAN.toString())
                        .build(),

                DonviRequest.builder()
                        .tenDonvi("Tiểu đoàn 18")
                        .kyhieuDonvi("d18")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.TIEU_DOAN.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Tiểu đoàn 24")
                        .kyhieuDonvi("d24")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.TIEU_DOAN.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Tiểu đoàn 25")
                        .kyhieuDonvi("d25")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.TIEU_DOAN.toString())
                        .build()
        );
    }
}
