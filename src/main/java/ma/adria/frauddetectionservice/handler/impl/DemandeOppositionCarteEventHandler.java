package ma.adria.frauddetectionservice.handler.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.model.event.DemandeOppositionCarteEvent;
import ma.adria.frauddetectionservice.dto.events.DemandeOppositionCarteEventDto;
import ma.adria.frauddetectionservice.dto.events.EventDto;
import ma.adria.frauddetectionservice.handler.EventHandler;
import ma.adria.frauddetectionservice.service.DemandeOppositionCarteEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class DemandeOppositionCarteEventHandler implements EventHandler {
    private final MapHelper mapHelper;
    private final DemandeOppositionCarteEventService demandeOppositionCarteEventService;


    @Override
    public EventDto handle(EventDto eventDto) {
        DemandeOppositionCarteEventDto demandeOppositionCarteEventDto = (DemandeOppositionCarteEventDto) eventDto;
        DemandeOppositionCarteEvent demandeOppositionCarteEvent = mapHelper.map(demandeOppositionCarteEventDto, DemandeOppositionCarteEvent.class);
        log.info("Mapped DemandeOppositionCarteEventDto to DemandeOppositionCarteEvent entity : {}",demandeOppositionCarteEvent);
        DemandeOppositionCarteEvent savedEvent = demandeOppositionCarteEventService.save(demandeOppositionCarteEvent);
        log.info("Saved DemandeOppositionCarteEvent: {}",savedEvent);
        return mapHelper.map(savedEvent, DemandeOppositionCarteEventDto.class);
    }
}
