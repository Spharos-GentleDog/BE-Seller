package egenius.Vendor.application.ports.in.port;

import egenius.Vendor.application.ports.in.query.GetVendorProductQuery;
import egenius.Vendor.application.ports.out.dto.GetVendorProductDto;

import java.util.List;

public interface GetVendorProductUseCase {

    List<GetVendorProductDto> getVendorProduct(GetVendorProductQuery getVendorProductQuery);
}
