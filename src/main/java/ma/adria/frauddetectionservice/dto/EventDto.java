package ma.adria.frauddetectionservice.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.adria.frauddetectionservice.deserializer.LocalDateTimeDeserializer;
import ma.adria.frauddetectionservice.enums.Canal;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class EventDto {
    private String id;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime timestamp ;
    private Canal canal;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime activityTime;
    private String username;
    private String bankCode;
    private String countryCode;
    private String segment;
    private LocationDto location;
    private ContratDto contrat;
    private DeviceDto device;
    private String motif;


}
