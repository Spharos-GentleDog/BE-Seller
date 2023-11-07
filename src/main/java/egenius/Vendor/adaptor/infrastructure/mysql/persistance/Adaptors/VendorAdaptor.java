package egenius.Vendor.adaptor.infrastructure.mysql.persistance.Adaptors;

import egenius.Vendor.adaptor.infrastructure.mysql.entity.VendorEntity;
import egenius.Vendor.application.ports.out.dto.CheckEmailDto;
import egenius.Vendor.application.ports.out.dto.FindVendorDto;
import egenius.Vendor.application.ports.out.port.FindVendorPort;
import egenius.Vendor.domain.enums.BusinessTypes;
import egenius.Vendor.domain.enums.VendorStatus;
import egenius.Vendor.adaptor.infrastructure.mysql.persistance.Converter.BusinessTypeConverter;
import egenius.Vendor.adaptor.infrastructure.mysql.persistance.Converter.VendorStatusConvertor;
import egenius.Vendor.adaptor.infrastructure.mysql.repository.VendorRepository;
import egenius.Vendor.application.ports.out.dto.VendorDto;
import egenius.Vendor.application.ports.out.port.CheckEmailPort;
import egenius.Vendor.application.ports.out.port.VendorPort;
import egenius.Vendor.domain.Vendor;
import egenius.Vendor.global.common.exception.BaseException;
import egenius.Vendor.global.common.response.BaseResponseStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class VendorAdaptor implements VendorPort, CheckEmailPort, FindVendorPort {


    // 엔터티의 상태 변화를 구현
    private final VendorRepository vendorRepository;
    private final BusinessTypeConverter businessTypeConverter;
    private final VendorStatusConvertor vendorStatusConvertor;

    // 회원가입
    @Override
    public VendorDto signUpVendor(Vendor vendor) {

        //DB에 데이터 저장하기 위한 변환 작업
        Integer businessTypeCode = businessTypeConverter.convertToDatabaseColumn(vendor.getBusinessType());
        Integer VendorStatusCode = vendorStatusConvertor.convertToDatabaseColumn(vendor.getVendorStatus());
        String password = new BCryptPasswordEncoder().encode(vendor.getPassword());

        VendorEntity vendorEntity = vendorRepository.save(VendorEntity.signUpVendor(
                vendor.getVendorEmail(),
                vendor.getBusinessNumber(),
                password,
                vendor.getMailOrderNumber(),
                vendor.getBrandName(),
                vendor.getBrandLogoImageUrl(),
                vendor.getBrandContent(),
                vendor.getHomepageUrl(),
                businessTypeCode,
                vendor.getCompanyName(),
                vendor.getCompanyAddress(),
                vendor.getOpenedAt(),
                vendor.getVendorName(),
                vendor.getCallCenterNumber(),
                vendor.getManagerName(),
                vendor.getManagerPhoneNumber(),
                VendorStatusCode
                ));

        BusinessTypes businessTypeEnum = BusinessTypes.ofCodeValue(vendorEntity.getBusinessType());
        VendorStatus VendorStatusEnum = VendorStatus.ofCodeValue(vendorEntity.getVendorStatus());

        return VendorDto.formVendors(vendorEntity.getVendorEmail(),
                vendorEntity.getBusinessNumber(),
                vendorEntity.getPassword(),
                vendorEntity.getMailOrderNumber(),
                vendorEntity.getBrandName(),
                vendorEntity.getBrandLogoImageUrl(),
                vendorEntity.getBrandContent(),
                vendorEntity.getHomepageUrl(),
                businessTypeEnum.getNameValue(),
                vendorEntity.getVendorName(),
                vendorEntity.getCompanyAddress(),
                vendorEntity.getOpenedAt(),
                vendorEntity.getVendorName(),
                vendorEntity.getCallCenterNumber(),
                vendorEntity.getManagerName(),
                vendorEntity.getManagerPhoneNumber(),
                VendorStatusEnum.getNameValue()
                );
    }

    @Transactional(readOnly = true)
    @Override
    public CheckEmailDto checkEmail(String vendorEmail) {

        Optional<VendorEntity> vendorEmailEntity = vendorRepository.findByVendorEmail(vendorEmail);

        if(vendorEmailEntity.isPresent()){
            log.info("회원 존재");
            return CheckEmailDto.formCheckEmail(true);
        }
        log.info("회원 존재하지 않음");
        return CheckEmailDto.formCheckEmail(false);
    }

    @Override
    public Vendor findVendor(String vendorEmail) {

        VendorEntity vendorEntity = vendorRepository.findByVendorEmail(vendorEmail)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_VENDOR));

        return Vendor.signInVendor(
                vendorEntity.getVendorEmail(),
                vendorEntity.getPassword(),
                vendorEntity.getVendorName(),
                vendorEntity.getBrandLogoImageUrl(),
                vendorEntity.getDeactivate()
        );

    }
}
