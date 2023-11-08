package egenius.Vendor.adaptor.infrastructure.mysql.persistance.Adaptors;

import egenius.Vendor.adaptor.infrastructure.mysql.entity.BankAccountEntity;
import egenius.Vendor.adaptor.infrastructure.mysql.entity.VendorEntity;
import egenius.Vendor.adaptor.infrastructure.mysql.repository.VendorAccountRepository;
import egenius.Vendor.adaptor.infrastructure.mysql.repository.VendorRepository;
import egenius.Vendor.application.ports.out.port.CreateBankAccountPort;
import egenius.Vendor.domain.BankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VendorAccountAdaptor implements CreateBankAccountPort {

    private final VendorAccountRepository vendorAccountRepository;
    private final VendorRepository vendorRepository;

    @Override
    public void createBankAccount(BankAccount bankAccount) {

        Optional<VendorEntity> vendorEntity = vendorRepository.findByVendorEmail(bankAccount.getVendorEmail());

        BankAccountEntity bankAccountEntity = vendorAccountRepository.save(BankAccountEntity.createBankAccount(
                bankAccount.getBankName(),
                bankAccount.getBankAccountNumber(),
                bankAccount.getBankAccountHolder(),
                vendorEntity.get()
        ));
    }
}
