package ma.adria.frauddetectionservice.service;

import ma.adria.frauddetectionservice.exception.ElementNotFoundException;
import ma.adria.frauddetectionservice.model.BaseEntity;
import ma.adria.frauddetectionservice.model.Event;

import java.util.List;

public interface EventService{
    Event findByCode(String code) throws ElementNotFoundException;
    List<Event> findAll();
    Event save(Event event);
    void deleteById(Long id);
    authentification
    changerInfo
    gererBeneficiaire
    transactionByCard
            


}
