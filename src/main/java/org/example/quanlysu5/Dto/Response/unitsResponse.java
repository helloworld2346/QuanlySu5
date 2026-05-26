package org.example.quanlysu5.Dto.Response;

import lombok.Builder;
import org.example.quanlysu5.Enum.unitType;
import org.example.quanlysu5.Module.BaseEntity;

@Builder
public class unitsResponse extends BaseEntity {
    String unitName;
    String unitCode;
    unitType unitType;
    String superior_unit;
    String subordinate_units;
}
