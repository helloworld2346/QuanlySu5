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
public class DonViResponse extends BaseEntity {
    String tenDonvi;
    String donViCha;
    int quanSoTong;
    int quanSoHsqBs;
    int quanSoSiQuan;
    int quanSoQncn;
    List<String> donViCon;
}
