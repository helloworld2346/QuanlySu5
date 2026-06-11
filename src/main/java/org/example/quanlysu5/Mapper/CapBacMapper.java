package org.example.quanlysu5.Mapper;

import org.example.quanlysu5.Dto.Request.CapBacRequest;
import org.example.quanlysu5.Dto.Response.CapBacResponse;
import org.example.quanlysu5.Module.CapBacEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CapBacMapper {
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    CapBacEntity toEntity(CapBacRequest request);

    CapBacResponse toResponse(CapBacEntity role);
//    void update(@MappingTarget CapBacEntity role, RoleUpdate update);
}
