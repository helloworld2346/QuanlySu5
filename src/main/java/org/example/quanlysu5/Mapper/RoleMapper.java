package org.example.quanlysu5.Mapper;

import org.example.quanlysu5.Dto.Request.RoleRequest;
import org.example.quanlysu5.Dto.Response.RoleResponse;
import org.example.quanlysu5.Form.RoleUpdate;
import org.example.quanlysu5.Module.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    RoleEntity toEntity(RoleRequest request);

    @Mapping(target = "parent",ignore = true)
    RoleResponse toResponse(RoleEntity role);
    void update(@MappingTarget RoleEntity role, RoleUpdate update);
}
