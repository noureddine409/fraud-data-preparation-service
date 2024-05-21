package ma.adria.frauddetectionservice.handler.impl;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.Event.RemiseOrdreEvent;
import ma.adria.frauddetectionservice.dto.EventDto.EventDto;
import ma.adria.frauddetectionservice.dto.EventDto.EventDto.RemiseOrdreEventDto;
import ma.adria.frauddetectionservice.handler.EventHandler;
import ma.adria.frauddetectionservice.service.RemiseOrdreEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class RemiseOrdreEventHandler implements EventHandler {

    private final MapHelper mapHelper;

    private final RemiseOrdreEventService remiseOrdreEventService;

    @Override
    public void handle(EventDto eventDto) {
        RemiseOrdreEventDto remiseOrdreEventDto = (RemiseOrdreEventDto) eventDto;
        RemiseOrdreEvent remiseOrdreEvent = mapHelper.map(remiseOrdreEventDto, RemiseOrdreEvent.class);
        log.info("Mapped RemiseOrdreEventDto to RemiseOrdreEvent entity: {}", remiseOrdreEvent);
        RemiseOrdreEvent savedEvent = remiseOrdreEventService.save(remiseOrdreEvent);
        log.info("Saved RemiseOrdreEvent: {}", savedEvent);
    }
}
