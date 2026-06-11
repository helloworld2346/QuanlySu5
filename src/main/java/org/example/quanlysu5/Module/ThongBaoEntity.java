package org.example.quanlysu5.Module;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.example.quanlysu5.Enum.LoaiBaoBan;
import org.example.quanlysu5.Enum.LoaiMuctieu;

@Entity
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ThongBaoEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_thongbao",columnDefinition = "VARCHAR(36) COMMENT 'Id của thông báo'")
    String idThongbao;
    @Column(name = "tieu_de",columnDefinition = "VARCHAR(255) COMMENT 'tiêu đề thông báo'", nullable = false)
    String tieuDe;
    @Column(name = "noi_dung",columnDefinition = "VARCHAR(255) COMMENT 'nội dung thông báo'", nullable = false)
    String noiDung;
    @Column(name = "loai_thong_bao",columnDefinition = "VARCHAR(255) COMMENT 'loại thông báo'", nullable = false)
    String loaiThongBao;
    @Column(name = "da_doc",columnDefinition = "BOOLEAN COMMENT 'đã đọc'", nullable = false)
    Boolean daDoc;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20) COMMENT 'Loại mục tiêu'", nullable = false)
    @NotNull(message = "Loại mục tiêu không được null")
    LoaiMuctieu loaiMuctieu;
    @Column(name = "id_muctieu",columnDefinition = "VARCHAR(255) COMMENT 'id mục tiêu'", nullable = false)
    String idMuctieu;

}
