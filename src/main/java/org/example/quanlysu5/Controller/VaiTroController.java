package org.example.quanlysu5.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.example.quanlysu5.Dto.ApiResponse;
import org.example.quanlysu5.Dto.Request.VaiTroRequest;
import org.example.quanlysu5.Dto.Response.VaiTroResponse;
import org.example.quanlysu5.Mapper.VaiTroMapper;
import org.example.quanlysu5.Service.VaiTroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vaitro")
@RequiredArgsConstructor
@Tag(name = "Vai Tro API", description = "Quản lý vai trò")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class VaiTroController {

    VaiTroService vaiTroService;
    VaiTroMapper vaiTroMapper;

    @GetMapping
    public ApiResponse<List<VaiTroResponse>> getAllVaiTro() {
        return ApiResponse.<List<VaiTroResponse>>builder()
                .Result(vaiTroService.getAllRole())
                .message("Lấy danh sách vai trò thành công")
                .success(true)
                .code(0)
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<VaiTroResponse> getVaiTroById(
            @PathVariable String id) {

        return ApiResponse.<VaiTroResponse>builder()
                .Result(vaiTroService.getRoleResponseById(id))
                .message("Lấy vai trò thành công")
                .success(true)
                .code(0)
                .build();
    }

    @PostMapping
    public ApiResponse<VaiTroResponse> createVaiTro(
            @RequestBody VaiTroRequest request) {

        return ApiResponse.<VaiTroResponse>builder()
                .Result(vaiTroService.createRole(request))
                .message("Tạo vai trò thành công")
                .success(true)
                .code(0)
                .build();
    }
}