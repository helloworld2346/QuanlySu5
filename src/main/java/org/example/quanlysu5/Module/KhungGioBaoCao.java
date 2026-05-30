package org.example.quanlysu5.Module;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Entity
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KhungGioBaoCao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_khunggio",columnDefinition = "VARCHAR(36) COMMENT 'Id của khung giờ'")
    String idKhunggio;

    @Column(columnDefinition = "VARCHAR(255) COMMENT 'tên báo cáo'", nullable = false)
    String tenBaocao;

    @Column(columnDefinition = "DATE COMMENT 'Khung giờ bắt đầu'", nullable = false)
    Date khunggioBatdau;

    @Column(columnDefinition = "DATE COMMENT 'Khung giờ kết thúc'", nullable = false)
    Date khunggioKetthuc;
}
