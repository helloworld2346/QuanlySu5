package org.example.quanlysu5.Exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@NoArgsConstructor
public enum ErrorCode {
    INVALID_KEY(1001,"Invalid key", HttpStatus.BAD_REQUEST),
    FEATURE_NOT_FOUND(1002,"Feature Not Found", HttpStatus.NOT_FOUND),
    FEATURE_IS_EXIST(1003,"Feature Exist", HttpStatus.CONFLICT),
    ACCOUNT_NOT_FOUND(1002,"Không tìm thấy thông tin tài khoản", HttpStatus.NOT_FOUND),
    ACCOUNT_IS_EXIST(1003,"Trùng thông tin đăng nhập", HttpStatus.CONFLICT),
    ROLE_NOT_FOUND(1002,"Role Not Found", HttpStatus.NOT_FOUND),
    ROLE_IS_EXIST(1003,"Role Exist", HttpStatus.CONFLICT),
    UNAUTHENTICATED(1004,"Khong du quyen truy cap",HttpStatus.UNAUTHORIZED),
    UNCATEGORIZED(9999,"Uncategorized", HttpStatus.INTERNAL_SERVER_ERROR);
    ErrorCode(int Code,String Message, HttpStatusCode sponse){
        this.code = Code;
        this.message = Message;
        this.status = sponse;
    }
    private int code;
    private String message;
    private HttpStatusCode status;
}
