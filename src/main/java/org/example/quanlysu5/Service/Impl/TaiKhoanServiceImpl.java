package org.example.quanlysu5.Service.Impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.example.quanlysu5.Dto.Request.TaiKhoanRequest;
import org.example.quanlysu5.Dto.Response.TaiKhoan.TaiKhoanResponse;
import org.example.quanlysu5.Exception.AppException;
import org.example.quanlysu5.Exception.ErrorCode;
import org.example.quanlysu5.Mapper.TaiKhoanMapper;
import org.example.quanlysu5.Module.DonViEntity;
import org.example.quanlysu5.Module.TaikhoanEntity;
import org.example.quanlysu5.Module.VaiTroEntity;
import org.example.quanlysu5.Repo.DonViRepo;
import org.example.quanlysu5.Repo.TaiKhoanRepo;
import org.example.quanlysu5.Service.DonViService;
import org.example.quanlysu5.Service.TaiKhoanService;
import org.example.quanlysu5.Service.VaiTroService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TaiKhoanServiceImpl implements TaiKhoanService {
    private final DonViRepo donViRepo;
    private final TaiKhoanRepo taiKhoanRepo;
    TaiKhoanMapper taiKhoanMapper;
    DonViService donViService;
    VaiTroService vaiTroService;
    PasswordEncoder passwordEncoder;

    @Override
    public TaikhoanEntity getTaiKhoanById(String id) {
    log.info("Id user: "+id);
        return taiKhoanRepo.findById(id)
                .orElseThrow(()->new AppException(ErrorCode.ACCOUNT_NOT_FOUND));
    }

    @Override
    public TaiKhoanResponse getTaiKhoanResponse(String id) {
        TaikhoanEntity account=getTaiKhoanById(id);
        log.info(account.toString());
        return taiKhoanMapper.toResponse(account);
    }

    @Override
    public TaiKhoanResponse createdTaiKhoanResponse(TaiKhoanRequest taiKhoanRequest) {
        TaikhoanEntity taikhoanEntity=taiKhoanMapper.toEntity(taiKhoanRequest);
        String Mk=passwordEncoder.encode(taiKhoanRequest.getMatkhau());
        taiKhoanRepo.findByTenDangNhapAndMatKhau(taiKhoanRequest.getTenDangNhap(),Mk)
                .ifPresent(account -> {
                    throw new AppException(ErrorCode.ACCOUNT_IS_EXIST);
                });
                if (Boolean.TRUE.equals(taikhoanEntity.getKhoa())) {  
                    throw new AppException(ErrorCode.ACCOUNT_IS_EXIST);  
                }
        DonViEntity donViEntity=donViService.getById(taiKhoanRequest.getDonVi());
        VaiTroEntity vaiTroEntity=vaiTroService.getRoleById(taiKhoanRequest.getVaiTro());
        taikhoanEntity.setMatKhau(Mk);
        taikhoanEntity.setDonVi(donViEntity);
        taikhoanEntity.setVaiTro(vaiTroEntity);
        taikhoanEntity.setIsDeleted(false);
        taikhoanEntity.setCreatedAt(LocalDateTime.now());
        return taiKhoanMapper.toResponse(taiKhoanRepo.save(taikhoanEntity));
    }

    @Override  
    public List<TaiKhoanResponse> getAllTaiKhoan() {  
        return taiKhoanRepo.findByIsDeletedFalse()  
                .stream()  
                .map(taiKhoanMapper::toResponse)
                .toList();  
    }  
  
    @Override  
    public TaiKhoanResponse updateTaiKhoan(String idTaiKhoan, TaiKhoanRequest request) {  
        TaikhoanEntity taiKhoan = taiKhoanRepo  
                .findByIdTaiKhoanAndIsDeletedFalse(idTaiKhoan)  
                .orElseThrow(() -> new AppException(ErrorCode.ACCOUNT_NOT_FOUND));  
  
  
        if (request.getTenTaiKhoan() != null) {  
            taiKhoan.setTenTaiKhoan(request.getTenTaiKhoan());  
        }  
  
        if (request.getVaiTro() != null) {  
            VaiTroEntity vaiTro = vaiTroService.getRoleById(request.getVaiTro());  
            taiKhoan.setVaiTro(vaiTro);  
        }  
  
        if (request.getDonVi() != null) {  
            DonViEntity donVi = donViRepo.findById(request.getDonVi())  
                    .orElseThrow(() -> new AppException(ErrorCode.DONVI_NOT_FOUND));  
            taiKhoan.setDonVi(donVi);  
        }  
  
        return taiKhoanMapper.toResponse(taiKhoanRepo.save(taiKhoan)); 
    }  
  
    @Override  
    public void deleteTaiKhoan(String idTaiKhoan) {  
        TaikhoanEntity taiKhoan = taiKhoanRepo  
                .findByIdTaiKhoanAndIsDeletedFalse(idTaiKhoan)  
                .orElseThrow(() -> new AppException(ErrorCode.ACCOUNT_NOT_FOUND));  
  
        taiKhoan.setIsDeleted(true);  
        taiKhoan.setDeletedAt(LocalDateTime.now());  
        taiKhoanRepo.save(taiKhoan);  
    }  
  
    @Override  
    public void resetMatKhau(String idTaiKhoan, String matKhauMoi) {  
        TaikhoanEntity taiKhoan = taiKhoanRepo  
                .findByIdTaiKhoanAndIsDeletedFalse(idTaiKhoan)  
                .orElseThrow(() -> new AppException(ErrorCode.ACCOUNT_NOT_FOUND));  
  
        taiKhoan.setMatKhau(passwordEncoder.encode(matKhauMoi));  
        taiKhoanRepo.save(taiKhoan);  
    }  

    @Override  
    public TaiKhoanResponse lockTaiKhoan(String id) {  
        TaikhoanEntity taiKhoan = taiKhoanRepo  
            .findByIdTaiKhoanAndIsDeletedFalse(id)  
            .orElseThrow(() -> new AppException(ErrorCode.ACCOUNT_NOT_FOUND));  
        taiKhoan.setKhoa(true);  
        return taiKhoanMapper.toResponse(taiKhoanRepo.save(taiKhoan));  
    }  
    
    @Override  
    public TaiKhoanResponse unlockTaiKhoan(String id) {  
        TaikhoanEntity taiKhoan = taiKhoanRepo  
            .findByIdTaiKhoanAndIsDeletedFalse(id)  
            .orElseThrow(() -> new AppException(ErrorCode.ACCOUNT_NOT_FOUND));  
        taiKhoan.setKhoa(false);  
        return taiKhoanMapper.toResponse(taiKhoanRepo.save(taiKhoan));  
    }
}
