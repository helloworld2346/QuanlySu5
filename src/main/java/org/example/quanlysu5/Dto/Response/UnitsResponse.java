package org.example.quanlysu5.Dto.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.example.quanlysu5.Enum.unitType;
import org.example.quanlysu5.Module.BaseEntity;

import java.util.List;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UnitsResponse extends BaseEntity {
    String unitName;
    String unitCode;
    unitType unitType;
    String superior_unit;
    int totalOfTroops;
    int officer;
    int soldier;
    List<String> subordinate_units;
}
