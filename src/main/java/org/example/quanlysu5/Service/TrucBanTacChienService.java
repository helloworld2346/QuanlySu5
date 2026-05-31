package org.example.quanlysu5.Service;

import org.example.quanlysu5.Dto.Request.TrucBanTacChienRequest;
import org.example.quanlysu5.Dto.Response.DonViResponse;
import org.example.quanlysu5.Dto.Response.TrucBanTacChienResponse;
import org.example.quanlysu5.Form.TrucBanTacChienForm;
import org.example.quanlysu5.Module.TrucBanTacChienEntity;
import org.example.quanlysu5.Module.TrucChiHuyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrucBanTacChienService {
    List<TrucBanTacChienResponse> getAllTrucBanTacChienToResponse();
    TrucBanTacChienEntity getByIdNguoiTruc(String idNguoiTruc);
    TrucBanTacChienResponse getByIdNguoiTrucResponse(String idNguoiTruc);
    TrucBanTacChienResponse getByTenNguoiTruc(String tenNguoiTruc);
    TrucBanTacChienResponse createNguoiTruc(TrucBanTacChienRequest trucBanTacChienRequest);
    TrucBanTacChienResponse updateNguoiTruc(String idNguoiTruc, TrucBanTacChienForm update);
    void deleteNguoiTruc(String idNguoiTruc);


}
