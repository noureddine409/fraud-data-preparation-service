package ma.adria.frauddetectionservice.dto.events;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.adria.frauddetectionservice.common.CoreConstants;
import ma.adria.frauddetectionservice.dto.AccountDto;
import ma.adria.frauddetectionservice.dto.ContratDto;
import ma.adria.frauddetectionservice.dto.DeviceDto;
import ma.adria.frauddetectionservice.dto.LocationDto;
import ma.adria.frauddetectionservice.model.Event;
import ma.adria.frauddetectionservice.model.event.PayementFactureEvent;

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
    private PayementFactureEvent.StatusPayementFactureEvent statusPayementFactureEvent;

    @Builder
    public PayementFactureEventDto(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String reference, LocalDateTime timestamp, Event.Canal canal, LocalDateTime activityTime,
                                   String username, String bankCode, String countryCode, String segment, LocationDto location,
                                   ContratDto contrat, DeviceDto device, String motif, String creancier) {
        super(id, createdAt, updatedAt, reference, timestamp, canal, activityTime, username, bankCode, countryCode, segment, location, contrat, device, motif);
        this.creancier = creancier;
    }

    @Override
    public String getEventName() {
        return CoreConstants.EventNames.PAYEMENT_FACTURE;
    }
}
