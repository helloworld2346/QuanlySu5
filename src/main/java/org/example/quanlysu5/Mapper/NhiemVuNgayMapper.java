package org.example.quanlysu5.Mapper;

import org.example.quanlysu5.Dto.Request.NhiemVuNgayRequest;

import org.example.quanlysu5.Dto.Response.NhiemvuNgay.NhiemVuNgayResponse;
import org.example.quanlysu5.Form.KhungGioBaoCaoForm;
import org.example.quanlysu5.Form.NhiemVuNgayForm;
import org.example.quanlysu5.Module.KhungGioBaoCaoEntity;
import org.example.quanlysu5.Module.NhiemVuNgayEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface NhiemVuNgayMapper {

    @Mapping(target = "donBaoCao",ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    NhiemVuNgayEntity toEntity(NhiemVuNgayRequest request);

    NhiemVuNgayResponse toResponse(NhiemVuNgayEntity NhiemVuNgayEntity);
    @Mapping(target = "donBaoCao",ignore = true)
    void update(@MappingTarget NhiemVuNgayEntity nhiemVuNgay, NhiemVuNgayForm update);


}