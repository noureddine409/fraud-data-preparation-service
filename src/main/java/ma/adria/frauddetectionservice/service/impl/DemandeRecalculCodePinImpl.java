package ma.adria.frauddetectionservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.Event.DemandeRecalculCodePinEvent;
import ma.adria.frauddetectionservice.repository.AccountRepository;
import ma.adria.frauddetectionservice.repository.ContratRepository;
import ma.adria.frauddetectionservice.repository.DeviceRepository;
import ma.adria.frauddetectionservice.repository.GenericRepository;
import ma.adria.frauddetectionservice.service.DemandeRecalculCodePinEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class DemandeRecalculCodePinImpl extends EventGenericServiceImpl<DemandeRecalculCodePinEvent> implements DemandeRecalculCodePinEventService {
    public DemandeRecalculCodePinImpl(DeviceRepository deviceRepository, ContratRepository contratRepository, AccountRepository accountRepository, GenericRepository<DemandeRecalculCodePinEvent> genericRepository, MapHelper mapHelper) {
        super(deviceRepository, contratRepository, accountRepository, genericRepository, mapHelper);
    }

    @Override
    protected void prepareEvent(DemandeRecalculCodePinEvent event) {
        super.prepareEvent(event);
    }
}
