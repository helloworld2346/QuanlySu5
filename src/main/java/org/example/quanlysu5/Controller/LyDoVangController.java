package org.example.quanlysu5.Controller;

import lombok.RequiredArgsConstructor;
import org.example.quanlysu5.Dto.ApiResponse;
import org.example.quanlysu5.Dto.Request.LyDoVangRequest;
import org.example.quanlysu5.Dto.Response.LyDoVangResponse;
import org.example.quanlysu5.Service.LyDoVangService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ly-do-vang")
@RequiredArgsConstructor
public class LyDoVangController {

    private final LyDoVangService LyDoVangService;

    @GetMapping
    public ApiResponse<List<LyDoVangResponse>> getAll() {
        return ApiResponse.<List<LyDoVangResponse>>builder()
                .Result(LyDoVangService.getAllList())
                .success(true)
                .code(0)
                .message("Tìm danh sách lý do vắng thành công")
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<LyDoVangResponse> getById(
            @PathVariable String id
    ) {
        return ApiResponse.<LyDoVangResponse>builder()
                .Result(LyDoVangService.getByIdResponse(id))
                .success(true)
                .code(0)
                .message("Lấy lý do vắng thành công")
                .build();
    }

    @PostMapping
    public ApiResponse<LyDoVangResponse> create(
            @RequestBody LyDoVangRequest request
    ) {
        return ApiResponse.<LyDoVangResponse>builder()
                .Result(LyDoVangService.createLyDoVang(request))
                .success(true)
                .code(0)
                .message("Tạo lý do vắng thành công")
                .build();
    }
}