package ma.adria.frauddetectionservice.dispatcher;


import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.dto.EventDto.AuthenticationEventDto;
import ma.adria.frauddetectionservice.dto.EventDto.EventDto;
import ma.adria.frauddetectionservice.dto.EventDto.PayementFactureEventDto;
import ma.adria.frauddetectionservice.dto.EventDto.RemiseOrdreEventDto;
import ma.adria.frauddetectionservice.handler.EventHandler;
import ma.adria.frauddetectionservice.handler.impl.AuthenticationEventHandler;
import ma.adria.frauddetectionservice.handler.impl.PaymentFactureEventHandler;
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
        eventHandlers.put(PayementFactureEventDto.class, applicationContext.getBean(PaymentFactureEventHandler.class));


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
