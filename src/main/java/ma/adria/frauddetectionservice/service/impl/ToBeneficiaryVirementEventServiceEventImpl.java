package ma.adria.frauddetectionservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.Event.ToBeneficiaryVirementEvent;
import ma.adria.frauddetectionservice.repository.AccountRepository;
import ma.adria.frauddetectionservice.repository.ContratRepository;
import ma.adria.frauddetectionservice.repository.DeviceRepository;
import ma.adria.frauddetectionservice.repository.GenericRepository;
import ma.adria.frauddetectionservice.service.ToBeneficiaryVirementEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ToBeneficiaryVirementEventServiceEventImpl extends EventGenericServiceImpl<ToBeneficiaryVirementEvent> implements ToBeneficiaryVirementEventService {
    public ToBeneficiaryVirementEventServiceEventImpl(DeviceRepository deviceRepository, ContratRepository contratRepository, AccountRepository accountRepository, GenericRepository<ToBeneficiaryVirementEvent> genericRepository, MapHelper mapHelper) {
        super(deviceRepository, contratRepository, accountRepository, genericRepository, mapHelper);
    }
    @Override
    protected void prepareEvent(ToBeneficiaryVirementEvent event) {
        super.prepareEvent(event);
    }

}
