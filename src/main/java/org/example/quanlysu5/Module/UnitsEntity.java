package org.example.quanlysu5.Module;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.example.quanlysu5.Enum.unitType;

import java.util.List;

@Entity
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UnitsEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "VARCHAR(36) COMMENT 'ID đơn vị'")
    String unitId;

    @Column(columnDefinition = "VARCHAR(255) COMMENT 'tên đơn vị'", nullable = false)
    String unitName;

    @Column(columnDefinition = "VARCHAR(36) COMMENT 'mã đơn vị'", nullable = false)
    String unitCode;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20) COMMENT 'Loại đơn vị (Su_Doan,Trung_Doan,Tieu_Doan,Dai_Doi,)'", nullable = false)
    unitType unitType;
    @Column(columnDefinition = "INTERTER COMMENT 'Tổng quân số trong đơn vị đó'",nullable = false)
    int totalOfTroops;

    @Column(columnDefinition = "INTERTER COMMENT 'Quân số sĩ quan trong đơn vị đó'",nullable = false)
    int officer;

    @Column(columnDefinition = "INTERTER COMMENT 'Quân số chiến sĩ trong đơn vị đó'",nullable = false)
    int soldier;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    UnitsEntity superior_unit;

    @OneToMany(mappedBy = "superior_unit")
    List<UnitsEntity> subordinate_units;
    @Column(columnDefinition = "BOOLEAN  COMMENT 'trạng thái hoạt động'",nullable = false)
    Boolean isActive;
}
