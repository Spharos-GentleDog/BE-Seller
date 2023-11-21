package egenius.Vendor.adaptor.infrastructure.mysql.persistance.Converter;

import egenius.Vendor.domain.enums.BusinessTypes;
import egenius.Vendor.domain.enums.SalesStatus;
import egenius.Vendor.domain.enums.VendorStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.stereotype.Component;

@Converter
@Component
public class SalesStatusConverter implements AttributeConverter<SalesStatus,Integer> {


    @Override
    public Integer convertToDatabaseColumn(SalesStatus attribute) {
        return attribute.getCodeValue();
    }

    @Override
    public SalesStatus convertToEntityAttribute(Integer dbData) {
        return SalesStatus.ofCodeValue(dbData);
    }
}
