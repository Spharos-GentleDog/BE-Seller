package egenius.Vendor.domain;

import egenius.Vendor.domain.enums.BusinessTypes;
import egenius.Vendor.domain.enums.VendorStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class Vendor implements UserDetails {

    // 도메인 로직이 위치하는 곳
    // 도메인과 관련된 데이터 와 규칙이 들어 있어야 한다
    private String vendorEmail;
    private String businessNumber;
    private String vendorPassword;
    private String mailOrderNumber;
    private String brandName;
    private String brandLogoImageUrl;
    private String brandContent;
    private String homepageUrl;
    private BusinessTypes businessType;
    private String companyName;
    private String companyAddress;
    private LocalDate openedAt;
    private String VendorName;
    private String callCenterNumber;
    private String managerName;
    private String managerPhoneNumber;
    private VendorStatus VendorStatus;
    private LocalDateTime deactivate;


    public static Vendor signUpVendor(String vendorEmail, String businessNumber, String vendorPassword, String mailOrderNumber,
                                      String brandName, String brandLogoImageUrl, String brandContent, String homepageUrl,
                                      BusinessTypes businessType, String companyName, String companyAddress, LocalDate openedAt,
                                      String VendorName, String callCenterNumber,String managerName, String managerPhoneNumber, VendorStatus VendorStatus) {
        return Vendor.builder()
                .vendorEmail(vendorEmail)
                .businessNumber(businessNumber)
                .vendorPassword(vendorPassword)
                .mailOrderNumber(mailOrderNumber)
                .brandName(brandName)
                .brandLogoImageUrl(brandLogoImageUrl)
                .brandContent(brandContent)
                .homepageUrl(homepageUrl)
                .businessType(businessType)
                .companyName(companyName)
                .companyAddress(companyAddress)
                .openedAt(openedAt)
                .VendorName(VendorName)
                .callCenterNumber(callCenterNumber)
                .managerName(managerName)
                .managerPhoneNumber(managerPhoneNumber)
                .VendorStatus(VendorStatus)
                .build();
    }

    public static Vendor signInVendor(String vendorEmail, String vendorPassword, String brandName,
                                      String brandLogoImageUrl, LocalDateTime deactivate) {
        return Vendor.builder()
                .vendorEmail(vendorEmail)
                .vendorPassword(vendorPassword)
                .brandName(brandName)
                .brandLogoImageUrl(brandLogoImageUrl)
                .deactivate(deactivate)
                .build();
    }


    //JWT 관련 메서드
    // UserDetails 인터페이스 구현
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 권한 반환
        return List.of(new SimpleGrantedAuthority("ROLE_VENDOR")); // role 추가
    }
    @Override
    public String getUsername() {
        // 유저네임 반환
        return brandName; // 이름으로 사용 하는 데이터 (Vendor : brandName)
    }

    @Override
    public String getPassword() {
        // 패스워드 반환
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        // 계정 만료 여부
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // 계정 잠금 여부
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 계정 패스워드 만료 여부
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 계정 활성화 여부
        return true;
    }
}
