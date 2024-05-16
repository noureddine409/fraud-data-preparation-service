package ma.adria.frauddetectionservice.service.impl;

import ma.adria.frauddetectionservice.model.AuthenticationEvent;
import ma.adria.frauddetectionservice.repository.ContratRepository;
import ma.adria.frauddetectionservice.repository.DeviceRepository;
import ma.adria.frauddetectionservice.repository.GenericRepository;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationEventService extends EventGenericServiceImpl<AuthenticationEvent> implements ma.adria.frauddetectionservice.service.AuthenticationEventService {
    public AuthenticationEventService(DeviceRepository deviceRepository, ContratRepository contratRepository, GenericRepository<AuthenticationEvent> genericRepository, MapHelper mapHelper) {
        super(deviceRepository, contratRepository, genericRepository, mapHelper);
    }
}
