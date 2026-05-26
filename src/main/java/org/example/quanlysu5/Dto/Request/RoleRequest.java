package org.example.quanlysu5.Dto.Request;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.example.quanlysu5.Module.FeatureEntity;

import java.util.HashSet;
import java.util.Set;

@Builder
public class RoleRequest {
    String roleName;

}
