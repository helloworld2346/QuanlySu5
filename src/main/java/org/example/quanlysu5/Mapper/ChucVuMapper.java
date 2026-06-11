package org.example.quanlysu5.Mapper;

import org.example.quanlysu5.Dto.Request.ChucVuRequest;
import org.example.quanlysu5.Dto.Response.ChucVuResponse;
import org.example.quanlysu5.Form.RoleUpdate;
import org.example.quanlysu5.Module.ChucVuEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ChucVuMapper {
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    ChucVuEntity toEntity(ChucVuRequest request);

    ChucVuResponse toResponse(ChucVuEntity role);
//    void update(@MappingTarget ChucVuEntity role, RoleUpdate update);
}
