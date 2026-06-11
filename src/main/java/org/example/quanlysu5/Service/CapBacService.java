package org.example.quanlysu5.Service;

import org.example.quanlysu5.Dto.Request.CapBacRequest;
import org.example.quanlysu5.Dto.Response.CapBacResponse;
import org.example.quanlysu5.Module.CapBacEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CapBacService {
    List<CapBacResponse> getAllList();
    CapBacEntity getByid(String id);
    CapBacResponse getByIdResponse(String id);
    CapBacResponse createCapBac(CapBacRequest request);
}
