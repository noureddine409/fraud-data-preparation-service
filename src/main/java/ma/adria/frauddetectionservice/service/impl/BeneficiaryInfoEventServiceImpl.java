package ma.adria.frauddetectionservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.Event.BeneficiaryInfoEvent;
import ma.adria.frauddetectionservice.model.Account;
import ma.adria.frauddetectionservice.repository.AccountRepository;
import ma.adria.frauddetectionservice.repository.ContratRepository;
import ma.adria.frauddetectionservice.repository.DeviceRepository;
import ma.adria.frauddetectionservice.repository.GenericRepository;
import ma.adria.frauddetectionservice.service.BeneficiaryInfoEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class BeneficiaryInfoEventServiceImpl extends EventGenericServiceImpl<BeneficiaryInfoEvent> implements BeneficiaryInfoEventService  {

    private final AccountRepository accountRepository;

    public BeneficiaryInfoEventServiceImpl(DeviceRepository deviceRepository, ContratRepository contratRepository, GenericRepository<BeneficiaryInfoEvent> genericRepository, MapHelper mapHelper , AccountRepository accountRepository1) {
        super(deviceRepository, contratRepository, genericRepository, mapHelper);
        this.accountRepository = accountRepository1;
    }

    @Override
    protected void prepareEvent(BeneficiaryInfoEvent event) {
        super.prepareEvent(event);
        event.setCompteDebitor(handleAccount(event.getCompteDebitor()));

    }
    private Account handleAccount(Account account) {
        if (account == null) {
            return null;
        }

        Optional<Account> existingAccount = accountRepository.findByAccountNumber(account.getAccountNumber());
        if (existingAccount.isPresent()) {
            log.info("Found existing Account with account number: {}", account.getAccountNumber());
            return existingAccount.get();
        } else {
            log.info("Saving new Account: {}", account);
            Account savedAccount = accountRepository.save(account);
            log.info("New Account saved: {}", savedAccount);
            return savedAccount;
        }
    }
}
