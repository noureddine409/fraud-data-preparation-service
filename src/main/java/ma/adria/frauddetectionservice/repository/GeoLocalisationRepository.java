package ma.adria.frauddetectionservice.repository;

import ma.adria.frauddetectionservice.model.GeoLocation;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeoLocalisationRepository extends JpaRepository<GeoLocation, Id> {
}
