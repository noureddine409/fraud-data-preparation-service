package ma.adria.frauddetectionservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.model.event.DemandeChequierEvent;
import ma.adria.frauddetectionservice.repository.AccountRepository;
import ma.adria.frauddetectionservice.repository.ContratRepository;
import ma.adria.frauddetectionservice.repository.DeviceRepository;
import ma.adria.frauddetectionservice.repository.GenericRepository;
import ma.adria.frauddetectionservice.service.DemandeChequierEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DemandeChequierEventServiceImpl extends EventGenericServiceImpl<DemandeChequierEvent> implements DemandeChequierEventService {
    public DemandeChequierEventServiceImpl(DeviceRepository deviceRepository, ContratRepository contratRepository, AccountRepository accountRepository, GenericRepository<DemandeChequierEvent> genericRepository, MapHelper mapHelper) {
        super(deviceRepository, contratRepository, accountRepository, genericRepository, mapHelper);
    }

    @Override
    protected void prepareEvent(DemandeChequierEvent event) {
        super.prepareEvent(event);
    }
}
