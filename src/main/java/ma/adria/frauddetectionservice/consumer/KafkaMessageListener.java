package ma.adria.frauddetectionservice.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.dto.AuthenticationEventDto;
import ma.adria.frauddetectionservice.model.Authentification;
import ma.adria.frauddetectionservice.repository.AuthRepository;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaMessageListener {

    private final ObjectMapper objectMapper;

    private final ModelMapper modelMapper = new ModelMapper();
    private final AuthRepository authRepository;

    public KafkaMessageListener(ObjectMapper objectMapper, AuthRepository authRepository) {
        this.objectMapper = objectMapper;
        this.authRepository = authRepository;
    }

    @KafkaListener(topics = "t.events.auth", groupId = "my-group")
    public void consume(String message) {
        log.info(message);
        try {
            AuthenticationEventDto authenticationEventDto = objectMapper.readValue(message, AuthenticationEventDto.class);
            log.info(authenticationEventDto.toString());
            Authentification authenticationEventEntity = modelMapper.map(authenticationEventDto, Authentification.class);
            authRepository.save(authenticationEventEntity);
        } catch (JsonProcessingException e) {
            log.error("failed to deserialize change event", e);
        }

    }
}



