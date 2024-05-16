package ma.adria.frauddetectionservice.service;

import ma.adria.frauddetectionservice.model.Event;

public interface EventGenericService<T extends Event> {
    T save(T event);
}
