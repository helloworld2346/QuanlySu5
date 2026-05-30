package org.example.quanlysu5.Service;

import org.example.quanlysu5.Dto.Response.TaiKhoanResponse;
import org.example.quanlysu5.Module.TaikhoanEntity;
import org.springframework.stereotype.Service;

@Service
public interface TaiKhoanService {
    TaikhoanEntity getTaiKhoanById(String id);
    TaiKhoanResponse getTaiKhoanResponse(String id);
}
