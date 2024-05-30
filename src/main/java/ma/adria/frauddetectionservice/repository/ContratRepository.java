package ma.adria.frauddetectionservice.repository;

import ma.adria.frauddetectionservice.model.Contrat;

import java.util.Optional;

public interface ContratRepository extends GenericRepository<Contrat> {
    Optional<Contrat> findByContratId(String contratId);

}
