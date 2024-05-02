package ma.adria.frauddetectionservice.repository;

import ma.adria.frauddetectionservice.model.DeviceInfo;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DeviceInfoRepository extends JpaRepository<DeviceInfo, Id> {
}
