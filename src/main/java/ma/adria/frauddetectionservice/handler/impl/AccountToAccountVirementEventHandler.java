package ma.adria.frauddetectionservice.handler.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.model.event.AccountToAccountVirementEvent;
import ma.adria.frauddetectionservice.dto.events.AccountToAccountVirementEventDto;
import ma.adria.frauddetectionservice.dto.events.EventDto;
import ma.adria.frauddetectionservice.handler.EventHandler;
import ma.adria.frauddetectionservice.service.AccountToAccountVirementEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class AccountToAccountVirementEventHandler implements EventHandler {
    private final MapHelper mapHelper;
    private final AccountToAccountVirementEventService accountToAccountVirementEventService;

    @Override
    public EventDto handle(EventDto eventDto) {
        AccountToAccountVirementEventDto accountToAccountVirementEventDto = (AccountToAccountVirementEventDto) eventDto;
        AccountToAccountVirementEvent accountToAccountVirementEvent = mapHelper.map(accountToAccountVirementEventDto, AccountToAccountVirementEvent.class);
        log.info("Mapped AccountToAccountVirementEventDto to AccountToAccountVirementEvent entity : {}", accountToAccountVirementEvent);
        AccountToAccountVirementEvent savedEvent = accountToAccountVirementEventService.save(accountToAccountVirementEvent);
        log.info("Saved AccountToAccountVirementEvent: {}", savedEvent);
        return mapHelper.map(savedEvent, AccountToAccountVirementEventDto.class);
    }


}
