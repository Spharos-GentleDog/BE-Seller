package egenius.Vendor.adaptor.infrastructure.mysql.persistance.Converter;

import egenius.Vendor.domain.enums.BusinessTypes;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.stereotype.Component;

@Converter
@Component
public class BusinessTypeConverter implements AttributeConverter<BusinessTypes,Integer>{

    // enum -> DB
    @Override
    public Integer convertToDatabaseColumn(BusinessTypes attribute) {

        return attribute.getCodeValue();
    }

    // DB -> Enum
    @Override
    public BusinessTypes convertToEntityAttribute(Integer dbData) {
        return BusinessTypes.ofCodeValue(dbData);
    }
}
