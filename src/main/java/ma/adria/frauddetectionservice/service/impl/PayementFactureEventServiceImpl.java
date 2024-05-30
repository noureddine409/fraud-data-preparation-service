package ma.adria.frauddetectionservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.model.event.PayementFactureEvent;
import ma.adria.frauddetectionservice.repository.AccountRepository;
import ma.adria.frauddetectionservice.repository.ContratRepository;
import ma.adria.frauddetectionservice.repository.DeviceRepository;
import ma.adria.frauddetectionservice.repository.GenericRepository;
import ma.adria.frauddetectionservice.service.PayementFactureEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PayementFactureEventServiceImpl extends EventGenericServiceImpl<PayementFactureEvent> implements PayementFactureEventService {

    public PayementFactureEventServiceImpl(DeviceRepository deviceRepository,
                                           ContratRepository contratRepository,
                                           GenericRepository<PayementFactureEvent> genericRepository,
                                           MapHelper mapHelper,
                                           AccountRepository accountRepository) {
        super(deviceRepository, contratRepository, accountRepository, genericRepository, mapHelper);
    }
    @Override
    protected void prepareEvent(PayementFactureEvent event) {
        super.prepareEvent(event);
        event.setCompteDebit(handleAccount(event.getCompteDebit()));
    }


}
