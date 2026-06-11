package org.example.quanlysu5.Mapper;

import org.example.quanlysu5.Dto.Request.LyDoVangRequest;
import org.example.quanlysu5.Dto.Response.LyDoVangResponse;
import org.example.quanlysu5.Module.LyDoVangEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LyDoVangMapper {
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    LyDoVangEntity toEntity(LyDoVangRequest request);

    LyDoVangResponse toResponse(LyDoVangEntity role);
//    void update(@MappingTarget LyDoVangEntity role, RoleUpdate update);
}
