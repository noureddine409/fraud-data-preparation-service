package ma.adria.frauddetectionservice.handler.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.model.event.DemandeRecalculCodePinEvent;
import ma.adria.frauddetectionservice.dto.events.DemandeRecalculCodePinEventDto;
import ma.adria.frauddetectionservice.dto.events.EventDto;
import ma.adria.frauddetectionservice.handler.EventHandler;
import ma.adria.frauddetectionservice.service.DemandeRecalculCodePinEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class DemandeRecalculCodePinEventHandler implements EventHandler {
    private final MapHelper mapHelper;
    private final DemandeRecalculCodePinEventService demandeRecalculCodePinEventService;

    @Override
    public EventDto handle(EventDto eventDto) {
        DemandeRecalculCodePinEventDto demandeRecalculCodePinEventDto= (DemandeRecalculCodePinEventDto) eventDto;
        DemandeRecalculCodePinEvent demandeRecalculCodePinEvent=mapHelper.map(demandeRecalculCodePinEventDto, DemandeRecalculCodePinEvent.class);
        log.info("Mapped DemandeRecalculCodePinEventDto to DemandeRecalculCodePinEvent entity : {}", demandeRecalculCodePinEvent);
        DemandeRecalculCodePinEvent savedEvent = demandeRecalculCodePinEventService.save(demandeRecalculCodePinEvent);
        log.info("Saved DemandeRecalculCodePinEvent: {}", savedEvent);
        return mapHelper.map(savedEvent, DemandeRecalculCodePinEventDto.class);
    }
}
