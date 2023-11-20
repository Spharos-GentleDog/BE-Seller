package egenius.Vendor.adaptor.infrastructure.mysql.persistance.Adaptors;

import egenius.Vendor.adaptor.infrastructure.mysql.entity.VendorEntity;
import egenius.Vendor.adaptor.infrastructure.mysql.entity.VendorProductEntity;
import egenius.Vendor.adaptor.infrastructure.mysql.persistance.Converter.DisplayStatusConverter;
import egenius.Vendor.adaptor.infrastructure.mysql.persistance.Converter.SalesStatusConverter;
import egenius.Vendor.adaptor.infrastructure.mysql.repository.VendorProductRepository;
import egenius.Vendor.adaptor.infrastructure.mysql.repository.VendorRepository;
import egenius.Vendor.application.ports.out.dto.GetVendorProductDto;
import egenius.Vendor.application.ports.out.port.CreateVendorProductPort;
import egenius.Vendor.application.ports.out.port.DeleteVendorProductPort;
import egenius.Vendor.application.ports.out.port.GetVendorProductPort;
import egenius.Vendor.application.ports.out.port.UpdateVendorProductPort;
import egenius.Vendor.domain.VendorProduct;
import egenius.Vendor.domain.enums.DisplayStatus;
import egenius.Vendor.domain.enums.SalesStatus;
import egenius.Vendor.global.common.exception.BaseException;
import egenius.Vendor.global.common.response.BaseResponseStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class VendorProductAdaptor implements CreateVendorProductPort, UpdateVendorProductPort, GetVendorProductPort,
        DeleteVendorProductPort {

    private final VendorProductRepository vendorProductRepository;
    private final VendorRepository vendorRepository;
    private final DisplayStatusConverter displayStatusConverter;
    private final SalesStatusConverter salesStatusConverter;

    @Override
    public void createVendorProduct(VendorProduct vendorProduct) {

        log.info("판매자 상품 생성");

        Optional<VendorEntity> vendorEntity = vendorRepository.findByVendorEmail(vendorProduct.getVendorEmail());
        if(vendorEntity.isEmpty()){
            throw new IllegalArgumentException("존재하지 않는 이메일입니다.");
        }

        DisplayStatus displayStatus = DisplayStatus.ofNameValue(vendorProduct.getDisplayStatus());
        Integer displayStatusCode = displayStatusConverter.convertToDatabaseColumn(displayStatus);

        SalesStatus salesStatus = SalesStatus.ofNameValue(vendorProduct.getSalesStatus());
        Integer salesStatusCode = salesStatusConverter.convertToDatabaseColumn(salesStatus);

        vendorProductRepository.save(VendorProductEntity.createVendorProductEntity(
                vendorEntity.get(),
                vendorProduct.getProductDetailId(),
                displayStatusCode,
                salesStatusCode,
                vendorProduct.getSalesCount(),
                vendorProduct.getSaveCount()
        ));


    }

    //todo : 상품 정보 변경 이거 id 값 프론트에서 받으면 된느데 왜 이렇게 짰지........ 나중에 바꾸기
    @Override
    public void updateVendorProduct(VendorProduct vendorProduct) {
        log.info("판매자 상품 정보 변경");

        VendorEntity vendorEntity = vendorRepository.findByVendorEmail(vendorProduct.getVendorEmail())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_VENDOR)
        );

        VendorProductEntity vendorProductEntity =
                vendorProductRepository.findByVendorIdAndProductDetailId(
                        vendorEntity,
                        vendorProduct.getProductDetailId());

        if(vendorProductEntity == null){
            throw new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT);
        }

        vendorProductEntity.updateVendorProductEntity(
                displayStatusConverter.convertToDatabaseColumn(DisplayStatus.ofNameValue(vendorProduct.getDisplayStatus())),
                salesStatusConverter.convertToDatabaseColumn(SalesStatus.ofNameValue(vendorProduct.getSalesStatus())),
                vendorProduct.getSalesCount(),
                vendorProduct.getSaveCount()
        );

        vendorProductRepository.save(vendorProductEntity);
    }

    @Override
    public List<GetVendorProductDto> getVendorProduct(String vendorEmail) {

        log.info("판매자 상품 조회");
        Optional<VendorEntity> vendorEntity = vendorRepository.findByVendorEmail(vendorEmail);
        if(vendorEntity.isEmpty()){
            throw new IllegalArgumentException("존재하지 않는 이메일입니다.");
        }

        List<VendorProductEntity> vendorProductEntityList = vendorProductRepository.findAllByVendorId(vendorEntity.get());

        if(vendorProductEntityList.isEmpty()){
            throw new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT);
        }

        List<GetVendorProductDto> getVendorProductDtoList =
                vendorProductEntityList.stream()
                        .map(vendorProductEntity -> {

                            DisplayStatus displayStatus = displayStatusConverter.convertToEntityAttribute(
                                    vendorProductEntity.getDisplayStatus());
                            SalesStatus salesStatus = salesStatusConverter.convertToEntityAttribute(
                                    vendorProductEntity.getSalesStatus());

                            String displayStatusName = displayStatus.getNameValue();
                            String salesStatusName = salesStatus.getNameValue();

                            return GetVendorProductDto.fromVendorProduct(
                                    vendorProductEntity.getProductDetailId(),
                                    displayStatusName,
                                    salesStatusName,
                                    vendorProductEntity.getSalesCount(),
                                    vendorProductEntity.getSaveCount());

                        })
                        .collect(Collectors.toList());
        return getVendorProductDtoList;

    }

    @Override
    public void deleteVendorProduct(VendorProduct vendorProduct) {
        log.info("판매자 상품 삭제");

        VendorEntity vendorEntity = vendorRepository.findByVendorEmail(vendorProduct.getVendorEmail())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_VENDOR)
                );

        VendorProductEntity vendorProductEntity =
                vendorProductRepository.findByVendorIdAndProductDetailId(
                        vendorEntity,
                        vendorProduct.getProductDetailId());

        if(vendorProductEntity == null){
            throw new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT);
        }

        vendorProductRepository.delete(vendorProductEntity);
    }
}
