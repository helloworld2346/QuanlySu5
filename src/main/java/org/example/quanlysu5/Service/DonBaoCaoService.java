package org.example.quanlysu5.Service;

import org.example.quanlysu5.Dto.Request.DonBaoCaoRequest;
import org.example.quanlysu5.Dto.Response.DonBaoCaoResponse;
import org.example.quanlysu5.Form.DonBaoCaoForm;
import org.example.quanlysu5.Module.DonBaoCaoEntity;
import org.example.quanlysu5.Module.DonBaoCaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DonBaoCaoService {
    List<DonBaoCaoResponse> getAllDonBaoCaoToResponse();
    DonBaoCaoEntity getByIdDonBaoCao(String idNguoiTruc);
    DonBaoCaoResponse createDonBaoCao(DonBaoCaoRequest DonBaoCaoRequest);
    DonBaoCaoResponse updateDonBaoCao(String idDonBaoCao, DonBaoCaoForm update);
    void deleteDonBaoCao(String idDonBaoCao);
}
