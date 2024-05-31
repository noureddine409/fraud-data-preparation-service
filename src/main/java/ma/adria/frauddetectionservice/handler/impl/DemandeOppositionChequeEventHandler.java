package ma.adria.frauddetectionservice.handler.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.dto.events.DemandeOppositionChequeEventDto;
import ma.adria.frauddetectionservice.dto.events.EventDto;
import ma.adria.frauddetectionservice.handler.EventHandler;
import ma.adria.frauddetectionservice.model.event.DemandeOppositionChequeEvent;
import ma.adria.frauddetectionservice.service.DemandeOppositionChequeEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class DemandeOppositionChequeEventHandler implements EventHandler {
    private final MapHelper mapHelper;

    private final DemandeOppositionChequeEventService demandeOppositionChequeEventService;


    @Override
    public EventDto handle(EventDto eventDto) {
        DemandeOppositionChequeEventDto demandeOppositionChequeEventDto = (DemandeOppositionChequeEventDto) eventDto;
        DemandeOppositionChequeEvent demandeOppositionChequeEvent = mapHelper.map(demandeOppositionChequeEventDto, DemandeOppositionChequeEvent.class);
        log.info("Mapped DemandeOppositionChequeEventDto to DemandeOppositionChequeEvent entity : {}", demandeOppositionChequeEvent);
        DemandeOppositionChequeEvent savedEvent = demandeOppositionChequeEventService.save(demandeOppositionChequeEvent);
        log.info("Saved DemandeOppositionChequeEvent: {}", savedEvent);
        return mapHelper.map(savedEvent, DemandeOppositionChequeEventDto.class);
    }
}
