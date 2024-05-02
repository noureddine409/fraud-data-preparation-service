package ma.adria.frauddetectionservice.repository;

import jakarta.persistence.Id;
import ma.adria.frauddetectionservice.model.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratRepository extends JpaRepository<Contrat, Id> {
}
