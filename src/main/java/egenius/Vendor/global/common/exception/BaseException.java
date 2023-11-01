package egenius.Vendor.global.common.exception;

import egenius.Vendor.global.common.response.BaseResponseStatus;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException{
    private BaseResponseStatus status;

    public BaseException(BaseResponseStatus status) {
        this.status = status;
    }
}