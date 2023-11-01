package egenius.Vendor.global.common.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor
public enum BaseResponseStatus {

    /**
     * 200: 요청 성공
     **/
    SUCCESS(HttpStatus.OK,true, 200, "요청에 성공하였습니다."),

    /**
     * 900: 기타 에러
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, false, 900, "Internal server error"),

    // 3000 : vendor 에러
    EMAIL_NOT_FOUND(HttpStatus.CONFLICT, false, 3001, "이미 사용중인 이메일 입니다."),
    //너무 많은 정보를 알려주는게 아닌가 싶기는 한데 일단은 넣었습니당
    BUSINESS_TYPE_IS_NOT_FOUND(HttpStatus.NOT_FOUND, false, 3002,"존재하지 않는 사업자 유형 입니다"),
    BUSINESS_TYPE_ERROR(HttpStatus.NOT_FOUND,false,3003,"사업자 유형을 올바르게 입력했는지 확인 하세요"),
    VENDOR_STATUS_IS_NOT_FOUND(HttpStatus.NOT_FOUND, false, 3004,"존재하지 않는 상태 입니다"),

    ;
    private final HttpStatusCode httpStatusCode;
    private final boolean isSuccess;
    private final int code;
    private String message;

}
