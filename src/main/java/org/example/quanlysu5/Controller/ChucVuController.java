package org.example.quanlysu5.Controller;

import lombok.RequiredArgsConstructor;
import org.example.quanlysu5.Dto.ApiResponse;
import org.example.quanlysu5.Dto.Request.ChucVuRequest;
import org.example.quanlysu5.Dto.Response.ChucVuResponse;
import org.example.quanlysu5.Service.ChucVuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chucvu")
@RequiredArgsConstructor
public class ChucVuController {

    private final ChucVuService chucVuService;

    @GetMapping
    public ApiResponse<List<ChucVuResponse>> getAll() {
        return ApiResponse.<List<ChucVuResponse>>builder()
                .Result(chucVuService.getAllList())
                .success(true)
                .code(0)
                .message("Tìm danh sách chức năng thành công")
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<ChucVuResponse> getById(
            @PathVariable String id
    ) {
        return ApiResponse.<ChucVuResponse>builder()
                .Result(chucVuService.getByIdResponse(id))
                .success(true)
                .code(0)
                .message("Lấy Chức năng thannh công")
                .build();
    }

    @PostMapping
    public ApiResponse<ChucVuResponse> create(
            @RequestBody ChucVuRequest request
    ) {
        return ApiResponse.<ChucVuResponse>builder()
                .Result(chucVuService.createChucVu(request))
                .success(true)
                .code(0)
                .message("Tạo đơn báo cáo thành công")
                .build();
    }
}