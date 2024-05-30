package ma.adria.frauddetectionservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.model.event.AuthenticationEvent;
import ma.adria.frauddetectionservice.repository.AccountRepository;
import ma.adria.frauddetectionservice.repository.ContratRepository;
import ma.adria.frauddetectionservice.repository.DeviceRepository;
import ma.adria.frauddetectionservice.repository.GenericRepository;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthenticationEventService extends EventGenericServiceImpl<AuthenticationEvent> implements ma.adria.frauddetectionservice.service.AuthenticationEventService {
    public AuthenticationEventService(DeviceRepository deviceRepository, ContratRepository contratRepository, GenericRepository<AuthenticationEvent> genericRepository, MapHelper mapHelper, AccountRepository accountRepository) {
        super(deviceRepository, contratRepository, accountRepository, genericRepository, mapHelper);
    }
}
