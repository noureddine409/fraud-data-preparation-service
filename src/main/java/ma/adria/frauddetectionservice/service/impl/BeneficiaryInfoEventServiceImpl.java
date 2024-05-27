package ma.adria.frauddetectionservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.Event.BeneficiaryInfoEvent;
import ma.adria.frauddetectionservice.repository.AccountRepository;
import ma.adria.frauddetectionservice.repository.ContratRepository;
import ma.adria.frauddetectionservice.repository.DeviceRepository;
import ma.adria.frauddetectionservice.repository.GenericRepository;
import ma.adria.frauddetectionservice.service.BeneficiaryInfoEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class BeneficiaryInfoEventServiceImpl extends EventGenericServiceImpl<BeneficiaryInfoEvent> implements BeneficiaryInfoEventService  {


    public BeneficiaryInfoEventServiceImpl(DeviceRepository deviceRepository, ContratRepository contratRepository, GenericRepository<BeneficiaryInfoEvent> genericRepository, MapHelper mapHelper , AccountRepository accountRepository) {
        super(deviceRepository, contratRepository, accountRepository, genericRepository, mapHelper);
    }

    @Override
    protected void prepareEvent(BeneficiaryInfoEvent event) {
        super.prepareEvent(event);
        event.setCompteDebitor(handleAccount(event.getCompteDebitor()));

    }

}
