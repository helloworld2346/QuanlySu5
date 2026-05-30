package org.example.quanlysu5.Dto.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VaiTroResponse {

    String roleId;
    String roleName;
    //Set<FeatureEntity> features = new HashSet<>();

}
