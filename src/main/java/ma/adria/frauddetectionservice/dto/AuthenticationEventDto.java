package ma.adria.frauddetectionservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.adria.frauddetectionservice.model.Event;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
public class AuthenticationEventDto extends EventDto {

    @Builder
    public AuthenticationEventDto(String reference, LocalDateTime timestamp, Event.Canal canal, LocalDateTime activityTime, String username, String bankCode, String countryCode, String segment, LocationDto location, ContratDto contrat, DeviceDto device, String motif) {
        super(reference, timestamp, canal, activityTime, username, bankCode, countryCode, segment, location, contrat, device, motif);
    }
}
