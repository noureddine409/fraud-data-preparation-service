package ma.adria.frauddetectionservice.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.adria.frauddetectionservice.deserializer.LocalDateTimeDeserializer;
import ma.adria.frauddetectionservice.enums.Canal;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
public abstract class EventDto {
    private String reference;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime timestamp;
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
