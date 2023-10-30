package egenius.Seller.adaptor.infrastructure.mysql.persistance.EnumConverter;

import egenius.Seller.adaptor.infrastructure.mysql.enums.SellerStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.stereotype.Component;

@Converter
@Component
public class SellerStatusConvertor implements AttributeConverter<SellerStatus, Integer> {

    // enum -> DB
    @Override
    public Integer convertToDatabaseColumn(SellerStatus attribute) {
        return attribute.getCodeValue();
    }

    //DB -> enum
    @Override
    public SellerStatus convertToEntityAttribute(Integer dbData) {
        return SellerStatus.ofCodeValue(dbData);
    }


}
