package ma.adria.frauddetectionservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.model.Account;
import ma.adria.frauddetectionservice.model.RemiseOrdreEvent;
import ma.adria.frauddetectionservice.repository.AccountRepository;
import ma.adria.frauddetectionservice.repository.ContratRepository;
import ma.adria.frauddetectionservice.repository.DeviceRepository;
import ma.adria.frauddetectionservice.repository.GenericRepository;
import ma.adria.frauddetectionservice.service.RemiseOrdreEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class RemiseOrdreEventServiceImpl extends EventGenericServiceImpl<RemiseOrdreEvent> implements RemiseOrdreEventService {
    public RemiseOrdreEventServiceImpl(DeviceRepository deviceRepository, ContratRepository contratRepository, GenericRepository<RemiseOrdreEvent> genericRepository, MapHelper mapHelper, AccountRepository accountRepository) {
        super(deviceRepository, contratRepository, genericRepository, mapHelper);
        this.accountRepository = accountRepository;
    }

    private final AccountRepository accountRepository;

    @Override
    protected void prepareEvent(RemiseOrdreEvent event) {
        super.prepareEvent(event);
        event.setCompteDebit(handleAccount(event.getCompteDebit()));
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