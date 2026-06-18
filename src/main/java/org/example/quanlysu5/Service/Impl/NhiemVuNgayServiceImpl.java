package org.example.quanlysu5.Service.Impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.example.quanlysu5.Dto.Request.NhiemVuNgayRequest;
import org.example.quanlysu5.Dto.Response.NhiemvuNgay.NhiemVuNgayResponse;
import org.example.quanlysu5.Exception.AppException;
import org.example.quanlysu5.Exception.ErrorCode;
import org.example.quanlysu5.Form.NhiemVuNgayForm;
import org.example.quanlysu5.Mapper.NhiemVuNgayMapper;
import org.example.quanlysu5.Module.DonBaoCaoEntity;
import org.example.quanlysu5.Module.NhiemVuNgayEntity;
import org.example.quanlysu5.Repo.NhiemVuNgayRepo;
import org.example.quanlysu5.Service.DonBaoCaoService;
import org.example.quanlysu5.Service.NhiemVuNgayService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class NhiemVuNgayServiceImpl implements NhiemVuNgayService {
    private final NhiemVuNgayMapper nhiemVuNgayMapper;
    private final NhiemVuNgayRepo nhiemVuNgayRepo;
    DonBaoCaoService donBaoCaoService;

    @Override
    public List<NhiemVuNgayResponse> getAllList() {

        return nhiemVuNgayRepo.findAllByIsDeleted(false)
                .stream().map(nhiemVuNgayMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public NhiemVuNgayResponse getById(String id) {
        return nhiemVuNgayMapper.toResponse(nhiemVuNgayRepo.findById(id)
                .orElseThrow(()->new AppException(ErrorCode.NHIEMVUNGAY_NOT_FOUND)));
    }

    @Override
    public NhiemVuNgayResponse getByIdDonBaoCao(String idDonBaoCao) {
        return nhiemVuNgayMapper.toResponse(nhiemVuNgayRepo.findByDonBaoCao_idDonBaoCao(idDonBaoCao)
                .orElseThrow(()->new AppException(ErrorCode.NHIEMVUNGAY_NOT_FOUND)));
    }

    @Override
    public NhiemVuNgayResponse createNhiemVuNgay(NhiemVuNgayRequest nhiemVuNgayRequest) {
        NhiemVuNgayEntity nhiemVuNgayEntity=nhiemVuNgayMapper.toEntity(nhiemVuNgayRequest);
        DonBaoCaoEntity donBaoCaoEntity=donBaoCaoService.getByIdDonBaoCao(nhiemVuNgayRequest.getDonBaoCao());
        nhiemVuNgayEntity.setDonBaoCao(donBaoCaoEntity);
        nhiemVuNgayEntity.setIsDeleted(false);
        nhiemVuNgayEntity.setCreatedAt(LocalDateTime.now());
        nhiemVuNgayRepo.save(nhiemVuNgayEntity);
        return nhiemVuNgayMapper.toResponse(nhiemVuNgayEntity);
    }

    @Override
    public NhiemVuNgayResponse updateNhiemVuNgay(NhiemVuNgayForm update,String nhiemVuNgay)
    {
        NhiemVuNgayEntity nv=nhiemVuNgayRepo.findById(nhiemVuNgay)
                .orElseThrow(()->new AppException(ErrorCode.NHIEMVUNGAY_NOT_FOUND));
        nhiemVuNgayMapper.update(nv,update);
        nhiemVuNgayRepo.save(nv);

        return nhiemVuNgayMapper.toResponse(nv);
    }
}
