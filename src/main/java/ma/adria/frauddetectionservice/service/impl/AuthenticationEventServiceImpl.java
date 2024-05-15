package ma.adria.frauddetectionservice.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.model.AuthenticationEvent;
import ma.adria.frauddetectionservice.model.Contrat;
import ma.adria.frauddetectionservice.model.Device;
import ma.adria.frauddetectionservice.repository.AuthenticationEventRepository;
import ma.adria.frauddetectionservice.repository.ContratRepository;
import ma.adria.frauddetectionservice.repository.DeviceRepository;
import ma.adria.frauddetectionservice.service.AuthenticationEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class AuthenticationEventServiceImpl implements AuthenticationEventService {

    private final DeviceRepository deviceRepository;
    private final ContratRepository contratRepository;
    private final AuthenticationEventRepository authenticationEventRepository;
    private final MapHelper mapHelper;

    @Override
    @Transactional
    public AuthenticationEvent save(AuthenticationEvent authenticationEvent) {
        log.info("Saving AuthenticationEvent: {}", authenticationEvent);

        authenticationEvent.setDevice(handleDevice(authenticationEvent.getDevice()));
        authenticationEvent.setContrat(handleContrat(authenticationEvent.getContrat()));

        AuthenticationEvent savedEvent = authenticationEventRepository.save(authenticationEvent);
        log.info("AuthenticationEvent saved: {}", savedEvent);
        return savedEvent;
    }

    private Contrat handleContrat(Contrat contrat) {
        if (contrat == null) {
            return null;
        }

        Optional<Contrat> existingContrat = contratRepository.findByContratID(contrat.getContratID());
        if (existingContrat.isPresent()) {
            log.info("Found existing Contrat with ID: {}", contrat.getContratID());
            mapHelper.mapWithSkipNull(contrat, existingContrat.get());
            Contrat updatedContrat = contratRepository.save(existingContrat.get());
            log.info("Updated Contrat: {}", updatedContrat);
            return updatedContrat;
        } else {
            log.info("Saving new Contrat: {}", contrat);
            Contrat savedContrat = contratRepository.save(contrat);
            log.info("New Contrat saved: {}", savedContrat);
            return savedContrat;
        }
    }

    private Device handleDevice(Device device) {
        if (device == null) {
            return null;
        }

        Optional<Device> existingDevice = deviceRepository.findByFingerprint(device.getFingerprint());
        if (existingDevice.isPresent()) {
            log.info("Found existing Device with fingerprint: {}", device.getFingerprint());
            mapHelper.mapWithSkipNull(device, existingDevice.get());
            Device updatedDevice = deviceRepository.save(existingDevice.get());
            log.info("Updated Device: {}", updatedDevice);
            return updatedDevice;
        } else {
            log.info("Saving new Device: {}", device);
            Device savedDevice = deviceRepository.save(device);
            log.info("New Device saved: {}", savedDevice);
            return savedDevice;
        }
    }
}
