package ma.adria.frauddetectionservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.Event.PayementFactureEvent;
import ma.adria.frauddetectionservice.model.Account;
import ma.adria.frauddetectionservice.repository.*;
import ma.adria.frauddetectionservice.service.PayementFactureEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class PayementFactureEventServiceImpl extends EventGenericServiceImpl<PayementFactureEvent> implements PayementFactureEventService {

    private final AccountRepository accountRepository;
    public PayementFactureEventServiceImpl(DeviceRepository deviceRepository,
                                           ContratRepository contratRepository,
                                           GenericRepository<PayementFactureEvent> genericRepository,
                                           MapHelper mapHelper,
                                           AccountRepository accountRepository) {
        super(deviceRepository, contratRepository, genericRepository, mapHelper);
        this.accountRepository = accountRepository;
    }
    @Override
    protected void prepareEvent(PayementFactureEvent event) {
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
