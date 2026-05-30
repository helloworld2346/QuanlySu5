package org.example.quanlysu5.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.quanlysu5.Dto.ApiResponse;
import org.example.quanlysu5.Dto.Response.TaiKhoanResponse;
import org.example.quanlysu5.Service.TaiKhoanService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
@Tag(name = "Account API", description = "Quản lý thông tin tài khoẻn")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountController {
    TaiKhoanService taiKhoanService;
    @GetMapping()
    public ApiResponse<TaiKhoanResponse> getAccountByToken(){
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        Jwt jwt = (Jwt) authentication.getPrincipal();

        String scope = jwt.getClaim("sub");
        return ApiResponse.<TaiKhoanResponse>builder()
                .code(0)
                .Result(taiKhoanService.getTaiKhoanResponse(scope))
                .message("Successfully")
                .success(true)
                .build();
    }
}
