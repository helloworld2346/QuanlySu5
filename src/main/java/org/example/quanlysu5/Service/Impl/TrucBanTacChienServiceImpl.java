package org.example.quanlysu5.Service.Impl;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.example.quanlysu5.Dto.Request.TrucBanTacChienRequest;
import org.example.quanlysu5.Dto.Response.TrucBanTacChienResponse;
import org.example.quanlysu5.Exception.AppException;
import org.example.quanlysu5.Exception.ErrorCode;
import org.example.quanlysu5.Form.TrucBanTacChienForm;
import org.example.quanlysu5.Mapper.TrucBanTacChienMapper;
import org.example.quanlysu5.Mapper.UnitsMapper;
import org.example.quanlysu5.Module.TrucBanTacChienEntity;
import org.example.quanlysu5.Repo.TrucBanTacChienRepo;
import org.example.quanlysu5.Service.TrucBanTacChienService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class TrucBanTacChienServiceImpl implements TrucBanTacChienService {
    private final TrucBanTacChienRepo trucBanTacChienRepo;
    TrucBanTacChienMapper trucBanTacChienMapper;

    @Override
    public List<TrucBanTacChienResponse> getAllTrucBanTacChienToResponse() {
        return trucBanTacChienRepo.findAllByIsDeleted(false).stream().map(trucBanTacChienMapper::toResponse)
                .collect((Collectors.toList()));
    }

    @Override
    public TrucBanTacChienEntity getByIdNguoiTruc(String idNguoiTruc) {
        return trucBanTacChienRepo.findById(idNguoiTruc)
                .orElseThrow(()->new AppException(ErrorCode.TRUCBANTACCHIEN_NOT_FOUND));
    }

    @Override
    public TrucBanTacChienResponse getByTenNguoiTruc(String tenNguoiTruc) {
        return trucBanTacChienMapper.toResponse(trucBanTacChienRepo.findByTenNguoitruc(tenNguoiTruc)
                .orElseThrow(()->new AppException(ErrorCode.TRUCBANTACCHIEN_NOT_FOUND)));
    }

    @Override
    public TrucBanTacChienResponse createNguoiTruc(TrucBanTacChienRequest trucBanTacChienRequest) {
        TrucBanTacChienEntity trucBanTacChien=trucBanTacChienMapper.toEntity(trucBanTacChienRequest);
        if(trucBanTacChienRepo.findBySodienthoaiAndIsDeleted(trucBanTacChien.getSodienthoai(),false)!=null){
            throw new AppException(ErrorCode.TRUCBANTACCHIEN_IS_EXIST);
        }

        return trucBanTacChienMapper.toResponse(trucBanTacChienRepo.save(trucBanTacChien));
    }

    @Override
    public TrucBanTacChienResponse updateNguoiTruc(String idNguoiTruc, TrucBanTacChienForm update) {

        if(trucBanTacChienRepo.findBySodienthoaiAndIsDeleted(update.getSodienthoai(),false)!=null){
            throw new AppException(ErrorCode.TRUCBANTACCHIEN_IS_EXIST);
        }
        TrucBanTacChienEntity trucBanTacChien=trucBanTacChienRepo.findById(idNguoiTruc)
                .orElseThrow(()->new AppException(ErrorCode.TRUCBANTACCHIEN_NOT_FOUND));
        trucBanTacChienMapper.update(trucBanTacChien,update);
        trucBanTacChienRepo.save(trucBanTacChien);
        return trucBanTacChienMapper.toResponse(trucBanTacChien);
    }

    @Override
    public void deleteNguoiTruc(String idNguoiTruc) {
        TrucBanTacChienEntity trucBanTacChien=trucBanTacChienRepo.findById(idNguoiTruc)
                .orElseThrow(()->new AppException(ErrorCode.TRUCBANTACCHIEN_NOT_FOUND));
        trucBanTacChien.setIsDeleted(true);
        trucBanTacChienRepo.save(trucBanTacChien);
    }
}
