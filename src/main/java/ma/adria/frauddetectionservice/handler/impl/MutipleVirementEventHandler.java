package ma.adria.frauddetectionservice.handler.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.Event.MutipleVirementEvent;
import ma.adria.frauddetectionservice.dto.EventDto.EventDto;
import ma.adria.frauddetectionservice.dto.EventDto.MutipleVirementEventDto;
import ma.adria.frauddetectionservice.handler.EventHandler;
import ma.adria.frauddetectionservice.service.MutipleVirementEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class MutipleVirementEventHandler implements EventHandler {
    private final MapHelper mapHelper;
    private final MutipleVirementEventService mutipleVirementEventService;

    @Override
    public void handle(EventDto eventDto){
        MutipleVirementEventDto mutipleVirementEventDto= (MutipleVirementEventDto) eventDto;
        MutipleVirementEvent mutipleVirementEvent=mapHelper.map(mutipleVirementEventDto, MutipleVirementEvent.class);
        log.info(" Mapped MutipleVirementEventDto to MutipleVirementEvent entity : {} ",mutipleVirementEvent);
        MutipleVirementEvent savedEvent = mutipleVirementEventService.save(mutipleVirementEvent);
        log.info("Saved MutipleVirementEvent: {}", savedEvent);
    }
}
