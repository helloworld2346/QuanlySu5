package org.example.quanlysu5.Module;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class FeatureEntity {

    @Column(name = "id")
    String id;

    @Column(name = "feature_name")
    String featureName;
    
}
