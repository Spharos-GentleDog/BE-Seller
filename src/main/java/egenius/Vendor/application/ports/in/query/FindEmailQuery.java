package egenius.Vendor.application.ports.in.query;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FindEmailQuery {

    private String managerName;
    private String managerPhoneNumber;

    public static FindEmailQuery toQuery(String managerName, String managerPhoneNumber){
        return FindEmailQuery.builder()
                .managerName(managerName)
                .managerPhoneNumber(managerPhoneNumber)
                .build();
    }

}
