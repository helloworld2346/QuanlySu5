package org.example.quanlysu5.Controller;

import lombok.RequiredArgsConstructor;
import org.example.quanlysu5.Dto.ApiResponse;
import org.example.quanlysu5.Dto.Request.ThongBaoRequest;
import org.example.quanlysu5.Dto.Response.ThongBaoResponse;
import org.example.quanlysu5.Service.ThongBaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/thongbao")
@RequiredArgsConstructor
public class ThongBaoController {

    private final ThongBaoService thongBaoService;

    @GetMapping("/{idMucTieu}")
    public ApiResponse<List<ThongBaoResponse>> getAllThongBao(
            @PathVariable String idMucTieu
    ) {

        return ApiResponse.<List<ThongBaoResponse>>builder()
                .success(true)
                .message("Lấy danh sách thông báo thành công")
                .Result(
                        thongBaoService.getAllThongBao(idMucTieu)
                )
                .build();
    }

    @PostMapping("/donvi")
    public ApiResponse<ThongBaoResponse> createThongBaoDonVi(
            @RequestBody ThongBaoRequest request
    ) {

        return ApiResponse.<ThongBaoResponse>builder()
                .success(true)
                .message("Tạo thông báo đơn vị thành công")
                .Result(
                        thongBaoService.createThongBaoDonVi(request)
                )
                .build();
    }

    @PostMapping("/taikhoan")
    public ApiResponse<ThongBaoResponse> createThongBaoTaiKhoan(
            @RequestBody ThongBaoRequest request
    ) {

        return ApiResponse.<ThongBaoResponse>builder()
                .success(true)
                .message("Tạo thông báo tài khoản thành công")
                .Result(
                        thongBaoService.createThongBaoTaiKhoan(request)
                )
                .build();
    }
    @DeleteMapping("/dadoc/{idMucTieu}")
    public ApiResponse<String> thongBaoDaDoc(
            @PathVariable String idMucTieu) {

        thongBaoService.thongBaoDaDoc(idMucTieu);

        return ApiResponse.<String>builder()
                .code(200)
                .message("Đã xóa thông báo đã đọc")
                .Result("Success")
                .build();
    }
}