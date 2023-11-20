package egenius.Vendor.application.ports.in.port;

import egenius.Vendor.application.ports.in.query.GetSalesCountQuery;
import egenius.Vendor.application.ports.out.dto.GetSalesCountDto;

public interface GetSalesCountUseCase {

    GetSalesCountDto getSalesCount(GetSalesCountQuery getSalesCountQuery);
}
