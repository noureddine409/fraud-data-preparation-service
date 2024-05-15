package ma.adria.frauddetectionservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
// for test purpose remove it when you're done
public class KafkaMessageController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaMessageController(KafkaTemplate<String, String> kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/publish")
    public String publishEvent(@RequestBody String jsonMessage) {
        try {
            kafkaTemplate.send("t.events.auth", jsonMessage);
            log.info("Published event to Kafka topic: {}", jsonMessage);
            return "Event published successfully to Kafka topic.";
        } catch (Exception e) {
            log.error("Error publishing event message: {}", e.getMessage());
            return "Failed to publish event to Kafka topic.";
        }
    }
}
