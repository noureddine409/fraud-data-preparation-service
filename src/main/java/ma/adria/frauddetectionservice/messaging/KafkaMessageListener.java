package ma.adria.frauddetectionservice.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.dispatcher.EventDispatcher;
import ma.adria.frauddetectionservice.dto.EventDto.EventDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class KafkaMessageListener {

    private final ObjectMapper objectMapper;
    private final EventDispatcher eventDispatcher;


    @KafkaListener(topics = "t.events", groupId = "my-group")
    public void consumeEvent(String message) {
        log.info("Received Kafka message: {}", message);
        try {
            EventDto eventDto = objectMapper.readValue(message, EventDto.class);
            eventDispatcher.dispatch(eventDto);
        } catch (JsonProcessingException e) {
            log.error("Error processing event message: {}", e.getMessage());
            log.debug("trace: {}", (Object[]) e.getStackTrace());
        }
    }


}
