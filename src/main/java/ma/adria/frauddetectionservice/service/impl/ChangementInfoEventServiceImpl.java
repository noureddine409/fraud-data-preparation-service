package ma.adria.frauddetectionservice.service.impl;

import ma.adria.frauddetectionservice.Event.ChangeInfoEvent;
import ma.adria.frauddetectionservice.repository.ContratRepository;
import ma.adria.frauddetectionservice.repository.DeviceRepository;
import ma.adria.frauddetectionservice.repository.GenericRepository;
import ma.adria.frauddetectionservice.service.ChangementInfoEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;


public class ChangementInfoEventServiceImpl extends EventGenericServiceImpl<ChangeInfoEvent> implements ChangementInfoEventService {
    public ChangementInfoEventServiceImpl(DeviceRepository deviceRepository, ContratRepository contratRepository, GenericRepository<ChangeInfoEvent> genericRepository, MapHelper mapHelper) {
        super(deviceRepository, contratRepository, genericRepository, mapHelper);
    }
    @Override
    protected void prepareEvent(ChangeInfoEvent event) {
        super.prepareEvent(event);
        //event.setCompteDebit(handleAccount(event.getCompteDebit()));
    }


}
