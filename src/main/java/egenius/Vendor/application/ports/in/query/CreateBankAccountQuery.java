package egenius.Vendor.application.ports.in.query;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateBankAccountQuery {

    private String bankName; // 은행명
    private String bankAccountNumber; //계좌번호
    private String bankAccountHolder; // 예금주
    private String vendorEmail; // 계좌 소유주에 대한 정보 (vendor_email)

    public static CreateBankAccountQuery toQuery(String bankName, String bankAccountNumber, String bankAccountHolder, String vendorEmail){
        return CreateBankAccountQuery.builder()
                .bankName(bankName)
                .bankAccountNumber(bankAccountNumber)
                .bankAccountHolder(bankAccountHolder)
                .vendorEmail(vendorEmail)
                .build();
    }
}
