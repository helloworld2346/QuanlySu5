package org.example.quanlysu5.Service.Impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.example.quanlysu5.Dto.Request.DonBaoCaoRequest;
import org.example.quanlysu5.Dto.Response.DonBaoCaoResponse;
import org.example.quanlysu5.Exception.AppException;
import org.example.quanlysu5.Exception.ErrorCode;
import org.example.quanlysu5.Form.DonBaoCaoForm;
import org.example.quanlysu5.Mapper.DonBaoCaoMapper;
import org.example.quanlysu5.Module.DonBaoCaoEntity;
import org.example.quanlysu5.Repo.DonBaoCaoRepo;
import org.example.quanlysu5.Service.DonBaoCaoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class DonBaoCaoServiceImpl implements DonBaoCaoService {
    private final DonBaoCaoRepo DonBaoCaoRepo;
    DonBaoCaoMapper DonBaoCaoMapper;

    @Override
    public List<DonBaoCaoResponse> getAllDonBaoCaoToResponse() {
        return DonBaoCaoRepo.findAllByIsDeleted(false).stream()
                .map(DonBaoCaoMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public DonBaoCaoEntity getByIdDonBaoCao(String idNguoiTruc) {
        return DonBaoCaoRepo.findById(idNguoiTruc)
                .orElseThrow(()->new AppException(ErrorCode.DONBAOCAO_NOT_FOUND));
    }

    @Override
    public DonBaoCaoResponse getByIdDonBaoCaoReponse(String idNguoiTruc) {
        return DonBaoCaoMapper.toResponse(getByIdDonBaoCao(idNguoiTruc));
    }

    @Override
    public DonBaoCaoResponse createDonBaoCao(DonBaoCaoRequest request) {

        DonBaoCaoEntity DonBaoCaoEntity = DonBaoCaoMapper.toEntity(request);

        DonBaoCaoEntity = DonBaoCaoRepo.save(DonBaoCaoEntity);

        return DonBaoCaoMapper.toResponse(DonBaoCaoEntity);
    }

    @Override
    public DonBaoCaoResponse updateDonBaoCao(String idDonBaoCao, DonBaoCaoForm update) {
        DonBaoCaoEntity DonBaoCao=DonBaoCaoRepo.findById(idDonBaoCao)
                .orElseThrow(()->new AppException(ErrorCode.DONBAOCAO_NOT_FOUND));
        DonBaoCaoMapper.update(DonBaoCao,update);
        DonBaoCaoRepo.save(DonBaoCao);
        return DonBaoCaoMapper.toResponse(DonBaoCao);
    }

    @Override
    public void deleteDonBaoCao(String idDonBaoCao) {
        DonBaoCaoEntity DonBaoCao=DonBaoCaoRepo.findById(idDonBaoCao)
                .orElseThrow(()->new AppException(ErrorCode.DONBAOCAO_NOT_FOUND));
        DonBaoCaoRepo.deleteById(idDonBaoCao);
    }
}
