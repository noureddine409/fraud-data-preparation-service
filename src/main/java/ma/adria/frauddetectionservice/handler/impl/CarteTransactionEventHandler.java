package ma.adria.frauddetectionservice.handler.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.Event.CarteTransactionEvent;
import ma.adria.frauddetectionservice.dto.EventDto.EventDto.CarteTransactionEventDto;
import ma.adria.frauddetectionservice.dto.EventDto.EventDto;
import ma.adria.frauddetectionservice.handler.EventHandler;
import ma.adria.frauddetectionservice.service.CarteTransactionEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class CarteTransactionEventHandler implements EventHandler {
    private final MapHelper mapHelper;
    private final CarteTransactionEventService carteTransactionEventService;

    @Override
    public void handle(EventDto eventDto) {
        CarteTransactionEventDto carteTransactionEventDto= (CarteTransactionEventDto) eventDto;
        CarteTransactionEvent carteTransactionEvent = mapHelper.map(carteTransactionEventDto, CarteTransactionEvent.class);
        log.info("Mapped CarteTransactionEventDto to CarteTransactionEvent entity : {}", carteTransactionEvent);
        CarteTransactionEvent savedEvent = carteTransactionEventService.save(carteTransactionEvent);
        log.info("Saved CarteTransactionEvent: {}", savedEvent);
    }
}
