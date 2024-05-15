package ma.adria.frauddetectionservice.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.dto.AuthenticationEventDto;
import ma.adria.frauddetectionservice.model.AuthenticationEvent;
import ma.adria.frauddetectionservice.service.AuthenticationEventService;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class KafkaMessageListener {

    private final ObjectMapper objectMapper;
    private final MapHelper mapHelper;
    private final AuthenticationEventService authenticationEventService;

    @KafkaListener(topics = "t.events.auth", groupId = "my-group")
    public void consume(String message) {
        log.info("Received Kafka message: {}", message);

        try {
            AuthenticationEventDto authenticationEventDto = objectMapper.readValue(message, AuthenticationEventDto.class);
            log.info("Deserialized AuthenticationEventDto: {}", authenticationEventDto);

            AuthenticationEvent authenticationEventEntity = mapHelper.map(authenticationEventDto, AuthenticationEvent.class);
            log.info("Mapped AuthenticationEventDto to AuthenticationEvent entity: {}", authenticationEventEntity);

            AuthenticationEvent savedEvent = authenticationEventService.save(authenticationEventEntity);
            log.info("Saved AuthenticationEvent: {}", savedEvent);
        } catch (JsonProcessingException e) {
            log.error("Failed to deserialize Kafka message: {}", message, e);
        } catch (Exception e) {
            log.error("Error processing Kafka message: {}", message, e);
        }
    }
}
