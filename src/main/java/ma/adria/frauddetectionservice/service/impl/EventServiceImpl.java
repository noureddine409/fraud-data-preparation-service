package ma.adria.frauddetectionservice.service.impl;

import ma.adria.frauddetectionservice.exception.ElementNotFoundException;
import ma.adria.frauddetectionservice.model.Event;
import ma.adria.frauddetectionservice.repository.EventRepository;
import ma.adria.frauddetectionservice.repository.GenericRepository;
import ma.adria.frauddetectionservice.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class EventServiceImpl extends Generi implements EventService {
    private final EventRepository eventRepository;

    public EventServiceImpl(GenericRepository<Event> genericRepository, MapHelper mapHelper, EventRepository eventRepository) {
        super(genericRepository, mapHelper);
        this.eventRepository = eventRepository;
    }

    @Override
    public Event findByCode(String code) {
        return eventRepository.findByCode(code).orElse(null);
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }
}
