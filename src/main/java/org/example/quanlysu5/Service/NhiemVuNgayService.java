package org.example.quanlysu5.Service;

import org.example.quanlysu5.Dto.Request.NhiemVuNgayRequest;
import org.example.quanlysu5.Dto.Response.NhiemvuNgay.NhiemVuNgayResponse;
import org.example.quanlysu5.Form.NhiemVuNgayForm;
import org.example.quanlysu5.Module.NhiemVuNgayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NhiemVuNgayService {
    List<NhiemVuNgayResponse> getAllList();
    NhiemVuNgayResponse getById(String id);
    NhiemVuNgayResponse getByIdDonBaoCao(String idDonBaoCao);
    NhiemVuNgayResponse createNhiemVuNgay(NhiemVuNgayRequest nhiemVuNgayRequest);
    NhiemVuNgayResponse updateNhiemVuNgay(NhiemVuNgayForm update,String nhiemVuNgay);
}
