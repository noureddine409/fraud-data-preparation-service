package ma.adria.frauddetectionservice.repository;

import ma.adria.frauddetectionservice.model.Authentification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Authentification,Long> {

}
