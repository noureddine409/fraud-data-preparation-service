package ma.adria.frauddetectionservice.dto.EventDto;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import ma.adria.frauddetectionservice.deserializer.LocalDateTimeDeserializer;
import ma.adria.frauddetectionservice.dto.*;
import ma.adria.frauddetectionservice.model.Event;

import java.time.LocalDateTime;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "@eventType"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AuthenticationEventDto.class, name = "AUTHENTICATION"),
        @JsonSubTypes.Type(value = RemiseOrdreEventDto.class, name = "REMISE_ORDRE"),
        @JsonSubTypes.Type(value = PayementFactureEventDto.class, name = "PAYEMENT_FACTURE")

})
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public abstract class EventDto {
    private String reference;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime timestamp;
    private Event.Canal canal;
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