package org.example.quanlysu5.Mapper;

import org.example.quanlysu5.Dto.Request.CaTrucRequest;
import org.example.quanlysu5.Dto.Response.CaTrucResponse;
import org.example.quanlysu5.Form.CaTrucForm;
import org.example.quanlysu5.Module.CaTrucEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CaTrucMapper {
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "donBaoCao", ignore = true)
    CaTrucEntity toEntity(CaTrucRequest request);

    CaTrucResponse toResponse(CaTrucEntity role);
    void update(@MappingTarget CaTrucEntity role, CaTrucForm update);
}
