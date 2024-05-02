package ma.adria.frauddetectionservice.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.model.BaseEntity;
import ma.adria.frauddetectionservice.service.GenericService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class GenericImpl <T extends BaseEntity> implements GenericService<T> {

}
