package egenius.Seller.domain.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum SellerStatus {

    READY(0,"대기"),
    APPROVE(1,"승인"),
    RETOUCH(2,"수정요청");

    private Integer codeValue;
    private String nameValue;


    SellerStatus(Integer codeValue, String nameValue){
        this.codeValue = codeValue;
        this.nameValue = nameValue;
    }

    // codeValue를 통해 해당 enum을 찾는 메소드
    public static SellerStatus ofCodeValue(Integer codeValue){

        return Arrays.stream(SellerStatus.values())
                .filter(v->v.getCodeValue().equals(codeValue))
                .findAny()
                .orElse(null);
    }

    public static SellerStatus ofNameValue(String nameValue){

        return Arrays.stream(SellerStatus.values())
                .filter(v->v.getNameValue().equals(nameValue))
                .findAny()
                .orElse(null);
    }

}
