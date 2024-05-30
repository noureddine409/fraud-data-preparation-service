package ma.adria.frauddetectionservice.handler.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.Event.DemandeLcnEvent;
import ma.adria.frauddetectionservice.dto.EventDto.DemandeLcnEventDto;
import ma.adria.frauddetectionservice.dto.EventDto.EventDto;
import ma.adria.frauddetectionservice.handler.EventHandler;
import ma.adria.frauddetectionservice.service.DemandeLcnEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Component;


@Component
@Slf4j
@AllArgsConstructor
public class DemandeLcnEventHandler implements EventHandler {

    private final MapHelper mapHelper;
    private final DemandeLcnEventService demandeLcnEventService;



    @Override
    public void handle(EventDto eventDto) {
        DemandeLcnEventDto demandeLcnEventDto = (DemandeLcnEventDto) eventDto;
        DemandeLcnEvent demandeLcnEvent = mapHelper.map(demandeLcnEventDto, DemandeLcnEvent.class);
        log.info("Mapped DemandeLcnEventDto to DemandeLcnEvent entity : {} ",demandeLcnEvent);
        DemandeLcnEvent savedEvent = demandeLcnEventService.save(demandeLcnEvent);
        log.info("Saved DemandeLcnEvent: {}",savedEvent);

    }
}