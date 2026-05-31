package org.example.quanlysu5.Service.Impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.example.quanlysu5.Dto.Request.VaiTroRequest;
import org.example.quanlysu5.Dto.Response.VaiTroResponse;
import org.example.quanlysu5.Exception.AppException;
import org.example.quanlysu5.Exception.ErrorCode;
import org.example.quanlysu5.Mapper.VaiTroMapper;
import org.example.quanlysu5.Module.VaiTroEntity;
import org.example.quanlysu5.Repo.VaiTroRepo;
import org.example.quanlysu5.Service.VaiTroService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class VaiTroServiceImpl implements VaiTroService {
    VaiTroRepo vaiTroRepo;
    VaiTroMapper vaiTroMapper;


    @Override
    public List<VaiTroResponse> getAllRole() {
        return vaiTroRepo.findAll().stream()
                .map(vaiTroMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public VaiTroEntity getRoleById(String id) {
        return vaiTroRepo.findById(id)
                .orElseThrow(()->new AppException(ErrorCode.ROLE_NOT_FOUND));
    }

    @Override
    public VaiTroEntity getRoleByName(String name) {
        return vaiTroRepo.findByTenVaiTro(name)
                .orElseThrow(()->new AppException(ErrorCode.ROLE_NOT_FOUND));
    }

    @Override
    public VaiTroResponse getRoleResponseById(String id) {
        return vaiTroMapper.toResponse(getRoleById(id));
    }

    @Override
    public VaiTroResponse createRole(VaiTroRequest vaiTroRequest) {
        VaiTroEntity vaiTroEntity = vaiTroMapper.toEntity(vaiTroRequest);
        vaiTroEntity.setIsDeleted(false);
        vaiTroEntity.setCreatedAt(LocalDateTime.now());
        log.info(vaiTroRequest.getTenVaiTro().toString());
        if(vaiTroRepo.findByTenVaiTro(vaiTroEntity.getTenVaiTro()).isPresent()){
            throw new AppException(ErrorCode.ROLE_IS_EXIST);
        }
        return vaiTroMapper.toResponse(vaiTroRepo.save(vaiTroEntity));
    }
}
