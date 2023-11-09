package egenius.Vendor.adaptor.infrastructure.mysql.entity;

import egenius.Vendor.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
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
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 올바르지 않은 객체 생성을 막아준다
@Entity
@Table(name= "Vendors")
public class VendorEntity extends BaseTimeEntity implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "vendor_email", nullable = false, length = 20)
    private String vendorEmail;

    @Column(name = "business_number", nullable = false, length = 20)
    private String businessNumber;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "mail_order_number", nullable = false, length = 20)
    private String mailOrderNumber;

    @Column(name = "brand_name", nullable = false, length = 20)
    private String brandName;

    @Column(name = "brand_logo_image_url", nullable = false, length = 100)
    private String brandLogoImageUrl;

    @Column(name = "brand_content", length = 150)
    private String brandContent;

    @Column(name = "homepage_url", length = 100)
    private String homepageUrl;

    @Column(name = "business_type", nullable = false)
    private Integer businessType;

    @Column(name = "company_name", nullable = false, length = 20)
    private String companyName;

    @Column(name = "company_address", length = 100)
    private String companyAddress;

    @Column(name = "opened_at", nullable = false )
    private LocalDate openedAt;

    @Column(name = "vendor_name", nullable = false, length = 20)
    private String vendorName;

    @Column(name = "call_center_number", nullable = false, length = 20)
    private String callCenterNumber;

    @Column(name = "manager_name", nullable = false, length = 20)
    private String managerName;

    @Column(name = "manager_phone_number", nullable = false, length = 20)
    private String managerPhoneNumber;

    @Column(name = "vendor_status", nullable = false, columnDefinition = "tinyint")
    private Integer vendorStatus;

    @Column(name = "deactivate")
    private LocalDateTime deactivate;


    public static VendorEntity signUpVendor(String vendorEmail, String businessNumber, String password,
                                            String mailOrderNumber, String brandName, String brandLogoImageUrl,
                                            String brandContent, String homepageUrl, Integer businessType,
                                            String companyName, String companyAddress, LocalDate openedAt,
                                            String vendorName, String callCenterNumber,String managerName,
                                            String managerPhoneNumber, Integer vendorStatus) {
        return VendorEntity.builder()
                .vendorEmail(vendorEmail)
                .businessNumber(businessNumber)
                .password(password)
                .mailOrderNumber(mailOrderNumber)
                .brandName(brandName)
                .brandLogoImageUrl(brandLogoImageUrl)
                .brandContent(brandContent)
                .homepageUrl(homepageUrl)
                .businessType(businessType)
                .companyName(companyName)
                .companyAddress(companyAddress)
                .openedAt(openedAt)
                .vendorName(vendorName)
                .callCenterNumber(callCenterNumber)
                .managerName(managerName)
                .managerPhoneNumber(managerPhoneNumber)
                .vendorStatus(vendorStatus)
                .build();
    }

    public static VendorEntity signInVendor(String vendorEmail) {
        return VendorEntity.builder()
                .vendorEmail(vendorEmail)
                .build();
    }


    //JWT 관련 메서드
    // UserDetails 인터페이스 구현
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 권한 반환
        return null; // role 추가
    }

    @Override
    public String getUsername() {
        // 유저네임 반환
        return vendorEmail; // 이름으로 사용 하는 데이터 (Vendor : brandName)
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
