package org.example.quanlysu5.Dto.Request;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.example.quanlysu5.Enum.unitType;
import org.example.quanlysu5.Module.BaseEntity;

@Builder
public class unitsRequest extends BaseEntity {
    String unitName;
    String unitCode;
    String unitType;
    String parent;
}
