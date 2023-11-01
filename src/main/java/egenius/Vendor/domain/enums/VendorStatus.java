package egenius.Vendor.domain.enums;

import egenius.Vendor.global.common.exception.BaseException;
import egenius.Vendor.global.common.response.BaseResponseStatus;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum VendorStatus {

    READY(0,"대기"),
    APPROVE(1,"승인"),
    RETOUCH(2,"수정요청");

    private Integer codeValue;
    private String nameValue;


    VendorStatus(Integer codeValue, String nameValue){
        this.codeValue = codeValue;
        this.nameValue = nameValue;
    }

    // codeValue를 통해 해당 enum을 찾는 메소드
    public static VendorStatus ofCodeValue(Integer codeValue){

        return Arrays.stream(VendorStatus.values())
                .filter(v->v.getCodeValue().equals(codeValue))
                .findAny()
                .orElseThrow(()-> new BaseException(BaseResponseStatus.VENDOR_STATUS_IS_NOT_FOUND));
    }

    public static VendorStatus ofNameValue(String nameValue){

        return Arrays.stream(VendorStatus.values())
                .filter(v->v.getNameValue().equals(nameValue))
                .findAny()
                .orElseThrow(()-> new BaseException(BaseResponseStatus.VENDOR_STATUS_IS_NOT_FOUND));
    }

}
