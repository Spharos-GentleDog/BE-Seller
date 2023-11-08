package egenius.Vendor.application.ports.out.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class InfoBankAccountDto {

    private String bankName; // 은행명
    private String bankAccountNumber; //계좌번호
    private String bankAccountHolder; // 예금주
    
    public static InfoBankAccountDto fromBankAccount(String bankName, String bankAccountNumber, String bankAccountHolder){
        return InfoBankAccountDto.builder()
                .bankName(bankName)
                .bankAccountNumber(bankAccountNumber)
                .bankAccountHolder(bankAccountHolder)
                .build();
    }
    
}
