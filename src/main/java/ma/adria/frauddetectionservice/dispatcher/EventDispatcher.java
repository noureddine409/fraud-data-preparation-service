package ma.adria.frauddetectionservice.dispatcher;


import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.Event.DemandeChequierEvent;
import ma.adria.frauddetectionservice.dto.EventDto.*;
import ma.adria.frauddetectionservice.handler.EventHandler;
import ma.adria.frauddetectionservice.handler.impl.*;
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
        eventHandlers.put(CarteTransactionEventDto.class, applicationContext.getBean(CarteTransactionEventHandler.class));
        eventHandlers.put(AccountToAccountVirementEventDto.class, applicationContext.getBean(AccountToAccountVirementEventHandler.class));
        eventHandlers.put(ToBeneficiaryVirementEventDto.class, applicationContext.getBean(ToBeneficiaryVirementEventHandler.class));
        eventHandlers.put(MutipleVirementEventDto.class, applicationContext.getBean(MutipleVirementEventHandler.class));
        eventHandlers.put(DemandeChequierEventDto.class, applicationContext.getBean(DemandeChequierEventHandler.class));


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
