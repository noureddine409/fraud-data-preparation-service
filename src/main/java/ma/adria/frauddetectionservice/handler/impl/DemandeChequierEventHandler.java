package ma.adria.frauddetectionservice.handler.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.Event.DemandeChequierEvent;
import ma.adria.frauddetectionservice.dto.EventDto.DemandeChequierEventDto;
import ma.adria.frauddetectionservice.dto.EventDto.EventDto;
import ma.adria.frauddetectionservice.handler.EventHandler;
import ma.adria.frauddetectionservice.service.DemandeChequierEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class DemandeChequierEventHandler implements EventHandler {
    private final MapHelper mapHelper;
    private final DemandeChequierEventService demandeChequierEventService;


    @Override
    public void handle(EventDto eventDto) {
        DemandeChequierEventDto demandeChequierEventDto = (DemandeChequierEventDto) eventDto;
        DemandeChequierEvent demandeChequierEvent = mapHelper.map(demandeChequierEventDto, DemandeChequierEvent.class);
        log.info("Mapped DemandeChequierEventDto to DemandeChequierEvent entity : {}", demandeChequierEvent);
        DemandeChequierEvent savedEvent = demandeChequierEventService.save(demandeChequierEvent);
        log.info("Saved DemandeChequierEvent: {}", savedEvent);
    }
}
