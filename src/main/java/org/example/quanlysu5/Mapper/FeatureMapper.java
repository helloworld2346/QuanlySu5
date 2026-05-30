package org.example.quanlysu5.Mapper;

import org.example.quanlysu5.Dto.Request.FeatureRequest;
import org.example.quanlysu5.Dto.Request.RoleRequest;
import org.example.quanlysu5.Dto.Response.FeatureResponse;
import org.example.quanlysu5.Dto.Response.RoleResponse;
import org.example.quanlysu5.Form.RoleUpdate;
import org.example.quanlysu5.Module.FeatureEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FeatureMapper {
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    FeatureEntity toEntity(FeatureRequest request);

    FeatureResponse toResponse(FeatureEntity role);
}
