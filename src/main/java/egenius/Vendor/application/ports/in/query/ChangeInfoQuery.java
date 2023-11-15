package egenius.Vendor.application.ports.in.query;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ChangeInfoQuery {

    private String email;
    private String brandLogoImageUrl;
    private String brandContent;
    private String homepageUrl;
    private String companyAddress;
    private String callCenterNumber;
    private String managerName;
    private String managerPhoneNumber;

    public static ChangeInfoQuery toQuery(String email, String brandLogoImageUrl, String brandContent, String homepageUrl,
                                             String companyAddress, String callCenterNumber, String managerName, String managerPhoneNumber){
        return ChangeInfoQuery.builder()
                .email(email)
                .brandLogoImageUrl(brandLogoImageUrl)
                .brandContent(brandContent)
                .homepageUrl(homepageUrl)
                .companyAddress(companyAddress)
                .callCenterNumber(callCenterNumber)
                .managerName(managerName)
                .managerPhoneNumber(managerPhoneNumber)
                .build();
    }
}
