package ma.adria.frauddetectionservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.model.event.DemandeLcnEvent;
import ma.adria.frauddetectionservice.repository.AccountRepository;
import ma.adria.frauddetectionservice.repository.ContratRepository;
import ma.adria.frauddetectionservice.repository.DeviceRepository;
import ma.adria.frauddetectionservice.repository.GenericRepository;
import ma.adria.frauddetectionservice.service.DemandeLcnEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DemandeLcnEventServiceImpl extends EventGenericServiceImpl<DemandeLcnEvent> implements DemandeLcnEventService {
    public DemandeLcnEventServiceImpl(DeviceRepository deviceRepository, ContratRepository contratRepository, AccountRepository accountRepository, GenericRepository<DemandeLcnEvent> genericRepository, MapHelper mapHelper) {
        super(deviceRepository, contratRepository, accountRepository, genericRepository, mapHelper);
    }

    @Override
    protected void prepareEvent(DemandeLcnEvent event) {
        super.prepareEvent(event);
    }
}
