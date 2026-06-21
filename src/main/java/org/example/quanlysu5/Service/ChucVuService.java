package org.example.quanlysu5.Service;

import org.example.quanlysu5.Dto.Request.ChucVuRequest;
import org.example.quanlysu5.Dto.Response.ChucVuResponse;
import org.example.quanlysu5.Module.ChucVuEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChucVuService {
    List<ChucVuResponse> getAllList();

    ChucVuEntity getByid(String id);

    ChucVuResponse getByIdResponse(String id);

    ChucVuResponse createChucVu(ChucVuRequest request);
}
