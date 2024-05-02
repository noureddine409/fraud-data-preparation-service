package ma.adria.frauddetectionservice.repository;

import ma.adria.frauddetectionservice.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericRepository <T extends BaseEntity> extends JpaRepository<T, Long>{

}
