package org.example.quanlysu5.Service.Impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.example.quanlysu5.Dto.Request.RoleRequest;
import org.example.quanlysu5.Dto.Response.RoleResponse;
import org.example.quanlysu5.Exception.AppException;
import org.example.quanlysu5.Exception.ErrorCode;
import org.example.quanlysu5.Mapper.RoleMapper;
import org.example.quanlysu5.Module.RoleEntity;
import org.example.quanlysu5.Repo.RoleRepo;
import org.example.quanlysu5.Service.RoleService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoleServiceImpl implements RoleService {
    RoleRepo roleRepo;
    RoleMapper roleMapper;


    @Override
    public List<RoleResponse> getAllRole() {
        return roleRepo.findAll().stream()
                .map(roleMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public RoleEntity getRoleById(String id) {
        return roleRepo.findById(id)
                .orElseThrow(()->new AppException(ErrorCode.ROLE_NOT_FOUND));
    }

    @Override
    public RoleEntity getRoleByName(String name) {
        return roleRepo.findByRoleName(name)
                .orElseThrow(()->new AppException(ErrorCode.ROLE_NOT_FOUND));
    }

    @Override
    public RoleResponse getRoleResponseById(String id) {
        return roleMapper.toResponse(getRoleById(id));
    }

    @Override
    public RoleEntity createRole(RoleRequest roleRequest) {
        RoleEntity roleEntity=roleMapper.toEntity(roleRequest);
        roleEntity.setIsDeleted(false);
        roleEntity.setCreatedAt(LocalDateTime.now());
        if(getRoleByName(roleEntity.getRoleName())!=null){
            throw new AppException(ErrorCode.ROLE_IS_EXIST);
        }
        return roleRepo.save(roleEntity);
    }
}
