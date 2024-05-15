package ma.adria.frauddetectionservice.repository;

import ma.adria.frauddetectionservice.model.Device;

import java.util.Optional;

public interface DeviceRepository extends GenericRepository<Device> {

    Optional<Device> findByFingerprint(String fingerprint);

}
