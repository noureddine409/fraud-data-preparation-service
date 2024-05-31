package ma.adria.frauddetectionservice.handler;

import ma.adria.frauddetectionservice.dto.events.EventDto;

public interface EventHandler {

    EventDto handle(EventDto event);
}
