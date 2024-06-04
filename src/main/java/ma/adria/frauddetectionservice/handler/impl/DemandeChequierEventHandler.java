package ma.adria.frauddetectionservice.handler.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.dto.events.DemandeChequierEventDto;
import ma.adria.frauddetectionservice.dto.events.EventDto;
import ma.adria.frauddetectionservice.handler.EventHandler;
import ma.adria.frauddetectionservice.model.event.DemandeChequierEvent;
import ma.adria.frauddetectionservice.service.DemandeChequierEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class DemandeChequierEventHandler implements EventHandler {
    private final MapHelper mapHelper;
    private final DemandeChequierEventService demandeChequierEventService;


    @Override
    public EventDto handle(EventDto eventDto) {
        DemandeChequierEventDto demandeChequierEventDto = (DemandeChequierEventDto) eventDto;
        DemandeChequierEvent demandeChequierEvent = mapHelper.map(demandeChequierEventDto, DemandeChequierEvent.class);
        log.info("Mapped DemandeChequierEventDto to DemandeChequierEvent entity : {}", demandeChequierEvent);
        DemandeChequierEvent savedEvent = demandeChequierEventService.save(demandeChequierEvent);
        log.info("Saved DemandeChequierEvent: {}", savedEvent);
        return mapHelper.map(savedEvent, DemandeChequierEventDto.class);
    }
}
