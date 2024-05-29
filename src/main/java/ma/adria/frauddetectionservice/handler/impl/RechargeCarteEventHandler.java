package ma.adria.frauddetectionservice.handler.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.Event.RechargeCarteEvent;
import ma.adria.frauddetectionservice.dto.EventDto.EventDto;
import ma.adria.frauddetectionservice.dto.EventDto.RechargeCarteEventDto;
import ma.adria.frauddetectionservice.handler.EventHandler;
import ma.adria.frauddetectionservice.service.RechargeCarteEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class RechargeCarteEventHandler implements EventHandler {

    private final MapHelper mapHelper;
    private final RechargeCarteEventService rechargeCarteEventService;

    @Override
    public void handle(EventDto eventDto) {
        RechargeCarteEventDto rechargeCarteEventDto = (RechargeCarteEventDto) eventDto;
        RechargeCarteEvent rechargeCarteEvent = mapHelper.map(rechargeCarteEventDto, RechargeCarteEvent.class);
        log.info("Mapped RechargeCarteEventDto to RechargeCarteEvent entity : {}", rechargeCarteEvent);
        RechargeCarteEvent savedEvent = rechargeCarteEventService.save(rechargeCarteEvent);
        log.info("Saved RechargeCarteEvent: {}",savedEvent);

    }
}
