package ma.adria.frauddetectionservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.Event.DemandeOppositionChequeEvent;
import ma.adria.frauddetectionservice.repository.AccountRepository;
import ma.adria.frauddetectionservice.repository.ContratRepository;
import ma.adria.frauddetectionservice.repository.DeviceRepository;
import ma.adria.frauddetectionservice.repository.GenericRepository;
import ma.adria.frauddetectionservice.service.DemandeOppositionChequeEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DemandeOppositionChequeEventServiceImpl extends EventGenericServiceImpl<DemandeOppositionChequeEvent> implements DemandeOppositionChequeEventService {
    public DemandeOppositionChequeEventServiceImpl(DeviceRepository deviceRepository, ContratRepository contratRepository, AccountRepository accountRepository, GenericRepository<DemandeOppositionChequeEvent> genericRepository, MapHelper mapHelper) {
        super(deviceRepository, contratRepository, accountRepository, genericRepository, mapHelper);
    }

    @Override
    protected void prepareEvent(DemandeOppositionChequeEvent event) {
        super.prepareEvent(event);
    }
}
