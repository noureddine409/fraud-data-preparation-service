package ma.adria.frauddetectionservice.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.model.Account;
import ma.adria.frauddetectionservice.model.Contrat;
import ma.adria.frauddetectionservice.model.Device;
import ma.adria.frauddetectionservice.model.Event;
import ma.adria.frauddetectionservice.repository.AccountRepository;
import ma.adria.frauddetectionservice.repository.ContratRepository;
import ma.adria.frauddetectionservice.repository.DeviceRepository;
import ma.adria.frauddetectionservice.repository.GenericRepository;
import ma.adria.frauddetectionservice.service.EventGenericService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class EventGenericServiceImpl<T extends Event> implements EventGenericService<T> {

    private final DeviceRepository deviceRepository;
    private final ContratRepository contratRepository;

    private final AccountRepository accountRepository;

    private final GenericRepository<T> genericRepository;

    private final MapHelper mapHelper;

    @Override
    @Transactional
    public T save(T event) {
        log.info("saving event {}", event);
        prepareEvent(event);
        T savedEvent = genericRepository.save(event);
        log.info("saved event {}", savedEvent);
        return savedEvent;
    }

    protected void prepareEvent(T event) {
        event.setDevice(handleDevice(event.getDevice()));
        event.setContrat(handleContrat(event.getContrat()));
    }

    private Contrat handleContrat(Contrat contrat) {
        if (contrat == null) {
            return null;
        }

        Optional<Contrat> existingContrat = contratRepository.findByContratId(contrat.getContratId());
        if (existingContrat.isPresent()) {
            log.info("Found existing Contrat with ID: {}", contrat.getContratId());
            mapHelper.mapWithSkipNull(contrat, existingContrat.get());
            Contrat updatedContrat = contratRepository.save(existingContrat.get());
            log.info("Updated Contrat: {}", updatedContrat);
            return updatedContrat;
        } else {
            log.info("Saving new Contrat: {}", contrat);
            Contrat savedContrat = contratRepository.save(contrat);
            log.info("New Contrat saved: {}", savedContrat);
            return savedContrat;
        }
    }

    protected Device handleDevice(Device device) {
        if (device == null) {
            return null;
        }

        Optional<Device> existingDevice = deviceRepository.findByFingerprint(device.getFingerprint());
        if (existingDevice.isPresent()) {
            log.info("Found existing Device with fingerprint: {}", device.getFingerprint());
            mapHelper.mapWithSkipNull(device, existingDevice.get());
            Device updatedDevice = deviceRepository.save(existingDevice.get());
            log.info("Updated Device: {}", updatedDevice);
            return updatedDevice;
        } else {
            log.info("Saving new Device: {}", device);
            Device savedDevice = deviceRepository.save(device);
            log.info("New Device saved: {}", savedDevice);
            return savedDevice;
        }
    }

    protected Account handleAccount(Account account) {
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
