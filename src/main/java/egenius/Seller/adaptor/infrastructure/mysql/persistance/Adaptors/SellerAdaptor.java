package egenius.Seller.adaptor.infrastructure.mysql.persistance.Adaptors;

import egenius.Seller.adaptor.infrastructure.mysql.entity.SellerEntity;
import egenius.Seller.adaptor.infrastructure.mysql.enums.BusinessTypes;
import egenius.Seller.adaptor.infrastructure.mysql.enums.SellerStatus;
import egenius.Seller.adaptor.infrastructure.mysql.persistance.EnumConverter.BusinessTypeConverter;
import egenius.Seller.adaptor.infrastructure.mysql.persistance.EnumConverter.SellerStatusConvertor;
import egenius.Seller.adaptor.infrastructure.mysql.repository.SellerRepository;
import egenius.Seller.application.ports.out.dto.SellerDto;
import egenius.Seller.application.ports.out.port.CheckEmailPort;
import egenius.Seller.application.ports.out.port.SellerPort;
import egenius.Seller.domain.Seller;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class SellerAdaptor implements SellerPort, CheckEmailPort {


    // 엔터티의 상태 변화를 구현
    private final SellerRepository sellerRepository;
    private final BusinessTypeConverter businessTypeConverter;
    private final SellerStatusConvertor sellerStatusConvertor;

    // 회원가입
    @Override
    public SellerDto signUpSeller(Seller seller) {

        //DB에 데이터 저장하기 위한 변환 작업
        Integer businessTypeCode = businessTypeConverter.convertToDatabaseColumn(BusinessTypes.ofNameValue(seller.getBusinessType()));
        Integer SellerStatusCode = sellerStatusConvertor.convertToDatabaseColumn(SellerStatus.ofNameValue(seller.getSellerStatus()));

        SellerEntity sellerEntity = sellerRepository.save(SellerEntity.signUpSeller(
                seller.getSellerEmail(),
                seller.getBusinessNumber(),
                seller.getSellerPw(),
                seller.getMailOrderNumber(),
                seller.getBrandName(),
                seller.getBrandLogoImg(),
                seller.getBrandContent(),
                seller.getHomepageUrl(),
                businessTypeCode,
                seller.getCompanyName(),
                seller.getCompanyAddress(),
                seller.getOpenedAt(),
                seller.getSellerName(),
                seller.getCallCenterNumber(),
                seller.getPhoneNumber(),
                SellerStatusCode
                ));

        BusinessTypes businessTypeValue = BusinessTypes.ofCodeValue(sellerEntity.getBusinessType());
        SellerStatus sellerStatusValue = SellerStatus.ofCodeValue(sellerEntity.getSellerStatus());

        return SellerDto.formSellers(sellerEntity.getSellerEmail(),
                sellerEntity.getBusinessNumber(),
                sellerEntity.getSellerPw(),
                sellerEntity.getMailOrderNumber(),
                sellerEntity.getBrandName(),
                sellerEntity.getBrandLogoImg(),
                sellerEntity.getBrandContent(),
                sellerEntity.getHomepageUrl(),
                businessTypeValue.getNameValue(),
                sellerEntity.getSellerName(),
                sellerEntity.getCompanyAddress(),
                sellerEntity.getOpenedAt().toLocalDate(),
                sellerEntity.getSellerName(),
                sellerEntity.getCallCenterNumber(),
                sellerEntity.getPhoneNumber(),
                sellerStatusValue.getNameValue()
                );
    }

    @Transactional(readOnly = true)
    @Override
    public boolean checkEmail(String sellerEmail) {

        Optional<SellerEntity> sellerEmailEntity = sellerRepository.findBySellerEmail(sellerEmail);

        if(sellerEmailEntity.isPresent()){
            log.info("회원 존재");
            return true;
        }
        log.info("회원 존재하지 않음");
        return false;
    }

}
