package org.example.quanlysu5.Data.TieuDoan24;

import org.example.quanlysu5.Dto.Request.DonviRequest;
import org.example.quanlysu5.Enum.CapDonVi;

import java.util.List;

public class TieuDoan24Data {
    public static List<DonviRequest> getData(String maCha) {

        return List.of(
                DonviRequest.builder()
                        .tenDonvi("Ban Nội")
                        .kyhieuDonvi("bn")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.BAN.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Ban Nội truyền nhiễm")
                        .kyhieuDonvi("bntn")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.BAN.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Ban Ngoại chung")
                        .kyhieuDonvi("bnc")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.BAN.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Ban Ngoại chấn thương")
                        .kyhieuDonvi("bnct")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.BAN.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Ban Phan loại hộ tống")
                        .kyhieuDonvi("bplht")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.BAN.toString())
                        .build(),
                DonviRequest.builder()
                        .tenDonvi("Ban dược")
                        .kyhieuDonvi("bd")
                        .donViCha(maCha)
                        .capDonVi(CapDonVi.BAN.toString())
                        .build()
        );
    }
}
