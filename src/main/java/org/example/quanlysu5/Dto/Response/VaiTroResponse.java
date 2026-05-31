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

    String idVaiTro;
    String tenVaiTro;
    //Set<FeatureEntity> features = new HashSet<>();

}
