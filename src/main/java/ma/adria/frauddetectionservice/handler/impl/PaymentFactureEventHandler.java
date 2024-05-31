package ma.adria.frauddetectionservice.handler.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.dto.events.EventDto;
import ma.adria.frauddetectionservice.dto.events.PayementFactureEventDto;
import ma.adria.frauddetectionservice.handler.EventHandler;
import ma.adria.frauddetectionservice.model.event.PayementFactureEvent;
import ma.adria.frauddetectionservice.service.PayementFactureEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class PaymentFactureEventHandler implements EventHandler {
    private final MapHelper mapHelper;
    private final PayementFactureEventService payementFactureEventService;

    @Override
    public EventDto handle(EventDto eventDto) {
        PayementFactureEventDto payementFactureEventDto = (PayementFactureEventDto) eventDto;
        PayementFactureEvent payementFactureEvent = mapHelper.map(payementFactureEventDto, PayementFactureEvent.class);
        log.info("Mapped PayementFcatureDto to PayementFactureEvent entity : {}", payementFactureEvent);
        PayementFactureEvent savedEvent = payementFactureEventService.save(payementFactureEvent);
        log.info("Saved PayementFactureEvent: {}", savedEvent);
        return mapHelper.map(savedEvent, PayementFactureEventDto.class);
    }
}
