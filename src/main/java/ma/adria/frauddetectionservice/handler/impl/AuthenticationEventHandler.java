package ma.adria.frauddetectionservice.handler.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.dto.events.AuthenticationEventDto;
import ma.adria.frauddetectionservice.dto.events.EventDto;
import ma.adria.frauddetectionservice.handler.EventHandler;
import ma.adria.frauddetectionservice.model.event.AuthenticationEvent;
import ma.adria.frauddetectionservice.service.AuthenticationEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Slf4j
public class AuthenticationEventHandler implements EventHandler {
    private final MapHelper mapHelper;

    private final AuthenticationEventService authenticationEventService;

    @Override
    public EventDto handle(EventDto eventDto) {
        AuthenticationEventDto authenticationEventDto = (AuthenticationEventDto) eventDto;
        AuthenticationEvent authenticationEventEntity = mapHelper.map(authenticationEventDto, AuthenticationEvent.class);
        log.info("Mapped AuthenticationEventDto to AuthenticationEvent entity: {}", authenticationEventEntity);
        AuthenticationEvent savedEvent = authenticationEventService.save(authenticationEventEntity);
        log.info("Saved AuthenticationEvent: {}", savedEvent);
        return mapHelper.map(savedEvent, AuthenticationEventDto.class);
    }
}
