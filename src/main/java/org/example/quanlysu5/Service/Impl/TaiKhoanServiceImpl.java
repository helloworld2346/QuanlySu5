package org.example.quanlysu5.Service.Impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.example.quanlysu5.Dto.Response.TaiKhoanResponse;
import org.example.quanlysu5.Exception.AppException;
import org.example.quanlysu5.Exception.ErrorCode;
import org.example.quanlysu5.Mapper.TaiKhoanMapper;
import org.example.quanlysu5.Module.TaikhoanEntity;
import org.example.quanlysu5.Repo.AccountRepo;
import org.example.quanlysu5.Service.TaiKhoanService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TaiKhoanServiceImpl implements TaiKhoanService {
    private final AccountRepo accountRepo;
    TaiKhoanMapper taiKhoanMapper;

    @Override
    public TaikhoanEntity getTaiKhoanById(String id) {
    log.info("Id user: "+id);
        return accountRepo.findById(id)
                .orElseThrow(()->new AppException(ErrorCode.ACCOUNT_NOT_FOUND));
    }

    @Override
    public TaiKhoanResponse getTaiKhoanResponse(String id) {
        TaikhoanEntity account=getTaiKhoanById(id);
        log.info(account.toString());
        return taiKhoanMapper.toResponse(account);
    }
}
