package org.example.quanlysu5.Module;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.example.quanlysu5.Enum.unitType;

import java.math.BigInteger;

@Entity
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class units extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "VARCHAR(36) COMMENT `ID đơn vị`")
    String unitId;

    @Column(columnDefinition = "VARCHAR(255) COMMENT 'tên đơn vị'", nullable = false)
    String unitName;

    @Column(columnDefinition = "VARCHAR(36) COMMENT 'mã đơn vị'", nullable = false)
    String unitCode;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20) COMMENT 'Loại đơn vị (Su_Doan,Trung_Doan,Tieu_Doan,Dai_Doi,)'", nullable = false)
    unitType unitType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    units parent;

    @Column(columnDefinition = "BOOLEAN  COMMENT 'trạng thái hoạt động'",nullable = false)
    Boolean isActive;
}
