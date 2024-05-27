package ma.adria.frauddetectionservice.handler.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.Event.AccountToAccountVirementEvent;
import ma.adria.frauddetectionservice.dto.EventDto.AccountToAccountVirementEventDto;
import ma.adria.frauddetectionservice.dto.EventDto.EventDto;
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
    public void handle(EventDto eventDto) {
        AccountToAccountVirementEventDto accountToAccountVirementEventDto = (AccountToAccountVirementEventDto) eventDto;
        AccountToAccountVirementEvent accountToAccountVirementEvent = mapHelper.map(accountToAccountVirementEventDto, AccountToAccountVirementEvent.class);
        log.info("Mapped AccountToAccountVirementEventDto to AccountToAccountVirementEvent entity : {}", accountToAccountVirementEvent);
        AccountToAccountVirementEvent savedEvent = accountToAccountVirementEventService.save(accountToAccountVirementEvent);
        log.info("Saved AccountToAccountVirementEvent: {}", savedEvent);
    }


}
