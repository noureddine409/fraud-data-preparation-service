package ma.adria.frauddetectionservice.handler.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.Event.AuthenticationEvent;
import ma.adria.frauddetectionservice.dto.EventDto.EventDto.AuthenticationEventDto;
import ma.adria.frauddetectionservice.dto.EventDto.EventDto;
import ma.adria.frauddetectionservice.handler.EventHandler;
import ma.adria.frauddetectionservice.service.AuthenticationEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
@Slf4j
public class AuthenticationEventHandler implements EventHandler {
    private final MapHelper mapHelper;

    private final AuthenticationEventService authenticationEventService;

    @Override
    public void handle(EventDto eventDto) {
        AuthenticationEventDto authenticationEventDto = (AuthenticationEventDto) eventDto;
        AuthenticationEvent authenticationEventEntity = mapHelper.map(authenticationEventDto, AuthenticationEvent.class);
        log.info("Mapped AuthenticationEventDto to AuthenticationEvent entity: {}", authenticationEventEntity);
        AuthenticationEvent savedEvent = authenticationEventService.save(authenticationEventEntity);
        log.info("Saved AuthenticationEvent: {}", savedEvent);
    }
}
