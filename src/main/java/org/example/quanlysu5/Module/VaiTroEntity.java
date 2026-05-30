package org.example.quanlysu5.Module;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VaiTroEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_vai_tro",columnDefinition = "VARCHAR(36) COMMENT 'Id của row quyền'")
    String idVaiTro;

    @Column(name = "ten_vai_tro",columnDefinition = "VARCHAR(36) COMMENT 'tên quyền'")
    String tenVaiTro;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "vaitro_chucnang",
            joinColumns = @JoinColumn(name = "id_vai_tro")
    )
    @Column(name = "ten_chucnang")
    Set<String> tenChucnang = new HashSet<>();

    @OneToMany(mappedBy="vaiTro")
    List<TaikhoanEntity> taiKhoan;
}
