package org.example.quanlysu5.Controller;

import lombok.RequiredArgsConstructor;
import org.example.quanlysu5.Dto.ApiResponse;
import org.example.quanlysu5.Dto.Request.CapBacRequest;
import org.example.quanlysu5.Dto.Response.CapBacResponse;
import org.example.quanlysu5.Service.CapBacService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/capbac")
@RequiredArgsConstructor
public class CapBacController {

    private final CapBacService CapBacService;

    @GetMapping
    public ApiResponse<List<CapBacResponse>> getAll() {
        return ApiResponse.<List<CapBacResponse>>builder()
                .Result(CapBacService.getAllList())
                .success(true)
                .code(0)
                .message("Tìm danh sách cấp bậc thành công")
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<CapBacResponse> getById(
            @PathVariable String id
    ) {
        return ApiResponse.<CapBacResponse>builder()
                .Result(CapBacService.getByIdResponse(id))
                .success(true)
                .code(0)
                .message("Lấy Cấp bậc thành công")
                .build();
    }

    @PostMapping
    public ApiResponse<CapBacResponse> create(
            @RequestBody CapBacRequest request
    ) {
        return ApiResponse.<CapBacResponse>builder()
                .Result(CapBacService.createCapBac(request))
                .success(true)
                .code(0)
                .message("Tạo cấp bậc thành công")
                .build();
    }
}