package egenius.Vendor.adaptor.infrastructure.mysql.persistance.Adaptors;

import egenius.Vendor.adaptor.infrastructure.mysql.repository.VendorAccountRepository;
import egenius.Vendor.adaptor.infrastructure.mysql.entity.VendorBankAccountEntity;
import egenius.Vendor.application.ports.out.port.VendorAccountPort;
import egenius.Vendor.domain.VendorBanckAccount;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VendorAccountAdaptor{

//    private final VendorAccountRepository VendorAccountRepository;
//    @Override
//    @Transactional
//    public VendorBanckAccount createVendorAccount(VendorBanckAccount VendorAccount) {
//
//        VendorBankAccountEntity vendorAccountEntity = VendorAccountRepository.save(VendorBankAccountEntity.createVendorAccount(
//                VendorAccount.getBankName(),
//                VendorAccount.getAccountNumber(),
//                VendorAccount.getOwnerName()
//        ));
//
//        return VendorAccount.formVendorAccountEntity(vendorAccountEntity);
//    }
}
