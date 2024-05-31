package ma.adria.frauddetectionservice.handler.impl;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.dto.events.EventDto;
import ma.adria.frauddetectionservice.dto.events.RemiseOrdreEventDto;
import ma.adria.frauddetectionservice.handler.EventHandler;
import ma.adria.frauddetectionservice.model.event.RemiseOrdreEvent;
import ma.adria.frauddetectionservice.service.RemiseOrdreEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class RemiseOrdreEventHandler implements EventHandler {

    private final MapHelper mapHelper;

    private final RemiseOrdreEventService remiseOrdreEventService;

    @Override
    public EventDto handle(EventDto eventDto) {
        RemiseOrdreEventDto remiseOrdreEventDto = (RemiseOrdreEventDto) eventDto;
        RemiseOrdreEvent remiseOrdreEvent = mapHelper.map(remiseOrdreEventDto, RemiseOrdreEvent.class);
        log.info("Mapped RemiseOrdreEventDto to RemiseOrdreEvent entity: {}", remiseOrdreEvent);
        RemiseOrdreEvent savedEvent = remiseOrdreEventService.save(remiseOrdreEvent);
        log.info("Saved RemiseOrdreEvent: {}", savedEvent);
        return mapHelper.map(savedEvent, RemiseOrdreEventDto.class);
    }
}
