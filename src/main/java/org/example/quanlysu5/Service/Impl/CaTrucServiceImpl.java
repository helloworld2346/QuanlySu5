package org.example.quanlysu5.Service.Impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.example.quanlysu5.Dto.Request.CaTrucRequest;
import org.example.quanlysu5.Dto.Response.CaTrucResponse;
import org.example.quanlysu5.Exception.AppException;
import org.example.quanlysu5.Exception.ErrorCode;
import org.example.quanlysu5.Form.CaTrucForm;
import org.example.quanlysu5.Mapper.CaTrucMapper;
import org.example.quanlysu5.Module.CaTrucEntity;
import org.example.quanlysu5.Repo.CaTrucRepo;
import org.example.quanlysu5.Service.CaTrucService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CaTrucServiceImpl implements CaTrucService {
    private final CaTrucRepo caTrucRepo;
    CaTrucMapper caTrucMapper;

    @Override
    public List<CaTrucResponse> getAllCaTrucToResponse() {
        return caTrucRepo.findAllByIsDeleted(false).stream()
                .map(caTrucMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public CaTrucEntity getByIdCaTruc(String idNguoiTruc) {
        return caTrucRepo.findById(idNguoiTruc)
                .orElseThrow(()->new AppException(ErrorCode.CATRUC_NOT_FOUND));
    }

    @Override
    public CaTrucResponse getByIdCaTrucResponse(String idNguoiTruc) {
        return caTrucMapper.toResponse(getByIdCaTruc(idNguoiTruc));
    }

    @Override
    public CaTrucResponse createCaTruc(CaTrucRequest request) {

        if (caTrucRepo.existsByNgaytruc(request.getNgaytruc())) {
            throw new AppException(ErrorCode.CATRUC_IS_EXIST);
        }

        CaTrucEntity caTrucEntity = caTrucMapper.toEntity(request);

        caTrucEntity = caTrucRepo.save(caTrucEntity);

        return caTrucMapper.toResponse(caTrucEntity);
    }

    @Override
    public CaTrucResponse updateCaTruc(String idCaTruc, CaTrucForm update) {
        CaTrucEntity caTruc=caTrucRepo.findById(idCaTruc).orElseThrow(()->new AppException(ErrorCode.CATRUC_NOT_FOUND));
        caTrucMapper.update(caTruc,update);
        caTrucRepo.save(caTruc);
        return caTrucMapper.toResponse(caTruc);
    }

    @Override
    public void deleteCaTruc(String idCaTruc) {
        CaTrucEntity caTruc=caTrucRepo.findById(idCaTruc).orElseThrow(()->new AppException(ErrorCode.CATRUC_NOT_FOUND));
        caTrucRepo.deleteById(idCaTruc);
    }
}
