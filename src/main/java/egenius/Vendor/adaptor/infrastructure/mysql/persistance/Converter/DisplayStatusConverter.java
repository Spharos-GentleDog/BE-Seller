package egenius.Vendor.adaptor.infrastructure.mysql.persistance.Converter;

import egenius.Vendor.domain.enums.BusinessTypes;
import egenius.Vendor.domain.enums.DisplayStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.stereotype.Component;

@Converter
@Component
public class DisplayStatusConverter implements AttributeConverter<DisplayStatus,Integer> {
    @Override
    public Integer convertToDatabaseColumn(DisplayStatus attribute) {
        return attribute.getCodeValue();
    }

    @Override
    public DisplayStatus convertToEntityAttribute(Integer dbData) {
        return DisplayStatus.ofCodeValue(dbData);
    }
}
