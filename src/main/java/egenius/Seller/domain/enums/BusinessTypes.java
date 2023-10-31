package egenius.Seller.domain.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum BusinessTypes {

    INDIVIDUAL(0,"개인"),
    CORPORATION(1,"법인");

    private Integer codeValue;
    private String nameValue;


    BusinessTypes(Integer codeValue, String nameValue){
        this.codeValue = codeValue;
        this.nameValue = nameValue;
    }

    // codeValue를 통해 해당 enum을 찾는 메소드
    public static BusinessTypes ofCodeValue(Integer codeValue){

        return Arrays.stream(BusinessTypes.values())
                .filter(v->v.getCodeValue().equals(codeValue))
                .findAny()
                .orElse(null);
    }

    // NameValue를 통해 해당 enum을 찾는 메소드
    public static BusinessTypes ofNameValue(String nameValue){

        return Arrays.stream(BusinessTypes.values())
                .filter(v->v.getNameValue().equals(nameValue))
                .findAny()
                .orElse(null);
    }
}
