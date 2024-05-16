package ma.adria.frauddetectionservice.dispatcher;


import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.dto.AuthenticationEventDto;
import ma.adria.frauddetectionservice.dto.EventDto;
import ma.adria.frauddetectionservice.dto.RemiseOrdreEventDto;
import ma.adria.frauddetectionservice.handler.EventHandler;
import ma.adria.frauddetectionservice.handler.impl.AuthenticationEventHandler;
import ma.adria.frauddetectionservice.handler.impl.RemiseOrdreEventHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class EventDispatcher {

    private final Map<Class<? extends EventDto>, EventHandler> eventHandlers;


    public EventDispatcher(ApplicationContext applicationContext) {
        this.eventHandlers = new HashMap<>();
        // Register event handlers
        eventHandlers.put(AuthenticationEventDto.class, applicationContext.getBean(AuthenticationEventHandler.class));
        eventHandlers.put(RemiseOrdreEventDto.class, applicationContext.getBean(RemiseOrdreEventHandler.class));

    }

    public void dispatch(EventDto event) {
        EventHandler eventHandler = eventHandlers.get(event.getClass());
        if (eventHandler != null) {
            eventHandler.handle(event);
        } else {
            log.warn("No handler found for event type: {}", event.getClass());
        }
    }
}
