package ma.adria.frauddetectionservice.dto.EventDto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.adria.frauddetectionservice.Event.PayementFactureEvent;
import ma.adria.frauddetectionservice.dto.AccountDto;
import ma.adria.frauddetectionservice.dto.ContratDto;
import ma.adria.frauddetectionservice.dto.DeviceDto;
import ma.adria.frauddetectionservice.dto.EventDto.EventDto;
import ma.adria.frauddetectionservice.dto.LocationDto;
import ma.adria.frauddetectionservice.model.Event;

import java.time.LocalDateTime;
@Getter
@Setter
@ToString(callSuper = true)

public class PayementFactureEventDto extends EventDto {
    private String creancier;
    private String creance;
    private String intituleClient;
    private AccountDto compteDebitor;
    private LocalDateTime dateCreation;
    private LocalDateTime dateEnvoie;
    private String amount;
    @Enumerated(EnumType.STRING)
    private PayementFactureEvent.StatusPayementFactureEvent statusPayementFactureEvent;

    @Builder
    public PayementFactureEventDto(String reference, LocalDateTime timestamp, Event.Canal canal, LocalDateTime activityTime,
                                   String username, String bankCode, String countryCode, String segment, LocationDto location,
                                   ContratDto contrat, DeviceDto device, String motif, String creancier) {
        super(reference, timestamp, canal, activityTime, username, bankCode, countryCode, segment, location, contrat, device, motif);
        this.creancier = creancier;
    }
}