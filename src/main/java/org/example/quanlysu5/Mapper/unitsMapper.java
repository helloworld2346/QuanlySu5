package org.example.quanlysu5.Mapper;

import org.example.quanlysu5.Dto.Request.unitsRequest;
import org.example.quanlysu5.Dto.Response.unitsResponse;
import org.example.quanlysu5.Module.units;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface unitsMapper {
    @Mapping(target = "parent",ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    units toEntity(unitsRequest request);

    @Mapping(target = "parent",ignore = true)
    unitsResponse toResponse(units units);
}
