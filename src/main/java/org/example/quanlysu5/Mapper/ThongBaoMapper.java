package org.example.quanlysu5.Mapper;

import org.example.quanlysu5.Dto.Request.ThongBaoRequest;
import org.example.quanlysu5.Dto.Response.ThongBaoResponse;
import org.example.quanlysu5.Module.ThongBaoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ThongBaoMapper {

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    ThongBaoEntity toEntity(ThongBaoRequest request);

    ThongBaoResponse toResponse(ThongBaoEntity ThongBaoEntity);

}