package ma.adria.frauddetectionservice.repository;

import ma.adria.frauddetectionservice.model.Location;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Id> {
}
