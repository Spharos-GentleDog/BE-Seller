package egenius.Vendor.adaptor.infrastructure.mysql.persistance.Adaptors;

import egenius.Vendor.adaptor.infrastructure.mysql.entity.BankAccountEntity;
import egenius.Vendor.adaptor.infrastructure.mysql.entity.VendorEntity;
import egenius.Vendor.adaptor.infrastructure.mysql.repository.VendorAccountRepository;
import egenius.Vendor.adaptor.infrastructure.mysql.repository.VendorRepository;
import egenius.Vendor.application.ports.out.dto.InfoBankAccountDto;
import egenius.Vendor.application.ports.out.port.CreateBankAccountPort;
import egenius.Vendor.application.ports.out.port.FindVendorPort;
import egenius.Vendor.application.ports.out.port.InfoBankAccountPort;
import egenius.Vendor.domain.BankAccount;
import egenius.Vendor.domain.Vendor;
import egenius.Vendor.global.common.exception.BaseException;
import egenius.Vendor.global.common.response.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VendorAccountAdaptor implements CreateBankAccountPort, InfoBankAccountPort {

    private final VendorAccountRepository vendorAccountRepository;
    private final VendorRepository vendorRepository;

    @Override
    public void createBankAccount(BankAccount bankAccount) {

        Optional<VendorEntity> vendorEntity = vendorRepository.findByVendorEmail(bankAccount.getVendorEmail());
//        String bankAccountNumber = new BCryptPasswordEncoder().encode(bankAccount.getBankAccountNumber());

        BankAccountEntity bankAccountEntity = vendorAccountRepository.save(BankAccountEntity.createBankAccount(
                bankAccount.getBankName(),
                bankAccount.getBankAccountNumber(),
                bankAccount.getBankAccountHolder(),
                vendorEntity.get()
        ));
    }

    @Override
    public InfoBankAccountDto getBankAccount(String vendorEmail) {

        Optional<VendorEntity> vendorEntity = vendorRepository.findByVendorEmail(vendorEmail);
        if(!vendorEntity.isPresent()) {
            throw new BaseException(BaseResponseStatus.NO_EXIST_VENDOR);
        }
        BankAccountEntity bankAccountEntity = vendorAccountRepository.findByVendorId(vendorEntity.get());
        System.out.print(bankAccountEntity);
        if(bankAccountEntity != null) {
            return InfoBankAccountDto.builder()
                    .bankName(bankAccountEntity.getBankName())
                    .bankAccountNumber(bankAccountEntity.getBankAccountNumber())
                    .bankAccountHolder(bankAccountEntity.getBankAccountHolder())
                    .build();
        }
        throw new BaseException(BaseResponseStatus.BANK_ACCOUNT_IS_NOT_FOUND);
    }
}
