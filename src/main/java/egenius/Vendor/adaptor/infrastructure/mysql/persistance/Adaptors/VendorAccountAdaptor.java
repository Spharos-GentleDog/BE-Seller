package egenius.Vendor.adaptor.infrastructure.mysql.persistance.Adaptors;

import egenius.Vendor.adaptor.infrastructure.mysql.repository.VendorAccountRepository;
import egenius.Vendor.adaptor.infrastructure.mysql.entity.VendorAccountEntity;
import egenius.Vendor.application.ports.out.port.VendorAccountPort;
import egenius.Vendor.domain.VendorAccount;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VendorAccountAdaptor implements VendorAccountPort {

    private final VendorAccountRepository VendorAccountRepository;
    @Override
    @Transactional
    public VendorAccount createVendorAccount(VendorAccount VendorAccount) {

        VendorAccountEntity vendorAccountEntity = VendorAccountRepository.save(VendorAccountEntity.createVendorAccount(
                VendorAccount.getBankName(),
                VendorAccount.getAccountNumber(),
                VendorAccount.getOwnerName()
        ));

        return VendorAccount.formVendorAccountEntity(vendorAccountEntity);
    }
}
