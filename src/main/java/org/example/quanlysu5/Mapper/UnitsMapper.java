package org.example.quanlysu5.Mapper;

import org.example.quanlysu5.Dto.Request.UnitsRequest;
import org.example.quanlysu5.Dto.Response.UnitsResponse;
import org.example.quanlysu5.Module.UnitsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UnitsMapper {

    @Mapping(target = "superior_unit", ignore = true)
    @Mapping(target = "subordinate_units", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    UnitsEntity toEntity(UnitsRequest request);

    @Mapping(
            target = "superior_unit",
            source = "superior_unit.unitName"
    )
    @Mapping(
            target = "subordinate_units",
            expression = "java(mapSubordinateUnits(UnitsEntity.getSubordinate_units()))"
    )
    UnitsResponse toResponse(UnitsEntity UnitsEntity);

    default List<String> mapSubordinateUnits(List<UnitsEntity> unitsEntityList) {

        if (unitsEntityList == null) {
            return List.of();
        }

        return unitsEntityList.stream()
                .map(UnitsEntity::getUnitName)
                .collect(Collectors.toList());
    }
}