package ma.adria.frauddetectionservice.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EventDTO extends BaseDTO{
    private String header;
    private JsonNode body;
}
