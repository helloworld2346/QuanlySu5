package org.example.quanlysu5.Form;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.example.quanlysu5.Module.BaseEntity;

import java.util.List;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DonviForm extends BaseEntity {
    int quanSoTong;
    int quanSoHsqBs;
    int quanSoSiQuan;
    int quanSoQncn;
    String tenDonvi;  
    String kyhieuDonvi;  
    String capDonVi;
    String donViCha; 
}
