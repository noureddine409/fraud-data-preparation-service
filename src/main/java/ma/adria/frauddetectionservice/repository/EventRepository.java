package ma.adria.frauddetectionservice.repository;

import ma.adria.frauddetectionservice.model.Event;

import java.util.Optional;

public interface EventRepository extends GenericRepository<Event>{
    Optional<Event> findByCode(String code);

}
