package ma.adria.frauddetectionservice.handler;

import ma.adria.frauddetectionservice.dto.EventDto;

public interface EventHandler {

    void handle(EventDto event);
}
