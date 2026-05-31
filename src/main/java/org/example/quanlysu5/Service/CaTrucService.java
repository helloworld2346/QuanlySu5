package org.example.quanlysu5.Service;

import org.example.quanlysu5.Dto.Request.CaTrucRequest;
import org.example.quanlysu5.Dto.Response.CaTrucResponse;
import org.example.quanlysu5.Form.CaTrucForm;
import org.example.quanlysu5.Module.CaTrucEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CaTrucService {
    List<CaTrucResponse> getAllCaTrucToResponse();
    CaTrucEntity getByIdCaTruc(String idNguoiTruc);
    CaTrucResponse getByIdCaTrucResponse(String idNguoiTruc);
    CaTrucResponse createCaTruc(CaTrucRequest CaTrucRequest);
    CaTrucResponse updateCaTruc(String idCaTruc, CaTrucForm update);
    void deleteCaTruc(String idCaTruc);


}
