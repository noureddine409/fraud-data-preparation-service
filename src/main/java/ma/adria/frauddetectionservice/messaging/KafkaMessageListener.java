package ma.adria.frauddetectionservice.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.adria.frauddetectionservice.dispatcher.EventDispatcher;
import ma.adria.frauddetectionservice.dispatcher.EventHandlerNotFoundException;
import ma.adria.frauddetectionservice.dto.events.EventDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaMessageListener {

    private final ObjectMapper objectMapper;
    private final EventDispatcher eventDispatcher;
    private final KafkaProducer kafkaProducer;

    @KafkaListener(topics = "t.events", groupId = "my-group")
    public void consumeEvent(String message) {
        log.info("Received Kafka message: {}", message);
        try {
            EventDto eventDto = objectMapper.readValue(message, EventDto.class);
            EventDto preparedEvent = eventDispatcher.dispatch(eventDto);
            forwardToAnalysisService(preparedEvent);
        } catch (JsonProcessingException e) {
            log.error("Error processing event message: {}", e.getMessage());
            log.debug("trace: {}", (Object[]) e.getStackTrace());
        } catch (EventHandlerNotFoundException e) {
            log.warn("No handler found : {}", e.getMessage());
        }
    }

    private void forwardToAnalysisService(EventDto preparedEvent) {
        try {
            ObjectNode jsonNode = objectMapper.valueToTree(preparedEvent);
            jsonNode.put("@eventType", preparedEvent.getEventName());
            String jsonEvent = objectMapper.writeValueAsString(jsonNode);
            kafkaProducer.sendEvent(jsonEvent);
        } catch (JsonProcessingException e) {
            log.error("Error processing event to JSON: {}", e.getMessage(), e);
        }
    }


}
