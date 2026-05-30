package org.example.quanlysu5.Dto.Request;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.example.quanlysu5.Module.BaseEntity;

import java.util.List;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UnitsRequest extends BaseEntity {
    String unitName;
    String unitCode;
    String unitType;
    int totalOfTroops;
    int officer;
    int soldier;
    String superior_unit;
    List<String> subordinate_units;
}
