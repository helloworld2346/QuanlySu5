package org.example.quanlysu5.Module;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NhiemVuNgayEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_nhiemvu_ngay",columnDefinition = "VARCHAR(36) COMMENT 'Id của nhiệm vụ ngày'")
    String idNhiemvuNgay;

    @Column(columnDefinition = "TEXT COMMENT 'Nhiệm vụ phân đội'", nullable = false)
    String nhiemVuPhandoi;

    @Column(columnDefinition = "TEXT COMMENT 'Nội dung đột xuất'", nullable = false)
    String noiDungDotXuat;

    @Column(columnDefinition = "TEXT COMMENT 'Nội dung ưu điểm'", nullable = false)
    String noiDungUuDiem;

    @Column(columnDefinition = "TEXT COMMENT 'Nội dung khuyết điểm'", nullable = false)
    String noiDungKhuyetDiem;

    @Column(columnDefinition = "TEXT COMMENT 'Nội dung cần giải quyết'", nullable = false)
    String noiDungCanGiaiQuyet;

    @OneToOne
    @JoinColumn(name = "id_don_bao_cao")
    DonBaoCaoEntity donBaoCao;
}
