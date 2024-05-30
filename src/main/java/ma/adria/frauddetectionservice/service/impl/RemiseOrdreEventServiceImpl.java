package ma.adria.frauddetectionservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.model.event.RemiseOrdreEvent;
import ma.adria.frauddetectionservice.repository.AccountRepository;
import ma.adria.frauddetectionservice.repository.ContratRepository;
import ma.adria.frauddetectionservice.repository.DeviceRepository;
import ma.adria.frauddetectionservice.repository.GenericRepository;
import ma.adria.frauddetectionservice.service.RemiseOrdreEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RemiseOrdreEventServiceImpl extends EventGenericServiceImpl<RemiseOrdreEvent> implements RemiseOrdreEventService {
    public RemiseOrdreEventServiceImpl(DeviceRepository deviceRepository, ContratRepository contratRepository, GenericRepository<RemiseOrdreEvent> genericRepository, MapHelper mapHelper, AccountRepository accountRepository) {
        super(deviceRepository, contratRepository, accountRepository, genericRepository, mapHelper);
    }


    @Override
    protected void prepareEvent(RemiseOrdreEvent event) {
        super.prepareEvent(event);
        event.setCompteDebit(handleAccount(event.getCompteDebit()));
    }



}
