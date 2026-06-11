package org.example.quanlysu5.Service;

import org.example.quanlysu5.Dto.Request.LyDoVangRequest;
import org.example.quanlysu5.Dto.Response.LyDoVangResponse;
import org.example.quanlysu5.Module.LyDoVangEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LyDoVangService {
    List<LyDoVangResponse> getAllList();
    LyDoVangEntity getByid(String id);
    LyDoVangResponse getByIdResponse(String id);
    LyDoVangResponse createLyDoVang(LyDoVangRequest request);
}
