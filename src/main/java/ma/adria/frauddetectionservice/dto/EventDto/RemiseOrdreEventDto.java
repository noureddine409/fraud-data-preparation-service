package ma.adria.frauddetectionservice.dto.EventDto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.adria.frauddetectionservice.dto.AccountDto;
import ma.adria.frauddetectionservice.dto.ContratDto;
import ma.adria.frauddetectionservice.dto.DeviceDto;
import ma.adria.frauddetectionservice.dto.EventDto.EventDto;
import ma.adria.frauddetectionservice.dto.LocationDto;
import ma.adria.frauddetectionservice.model.Event;
import ma.adria.frauddetectionservice.Event.RemiseOrdreEvent;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
public class RemiseOrdreEventDto extends EventDto {
    private String natureRemise;
    private String FormatRemiseOrdre;
    private String donneurOrdre;
    private AccountDto compteDebit;
    private String fichier;
    @Enumerated(EnumType.STRING)
    private RemiseOrdreEvent.AjouterRemiseStatus status;

    @Builder
    public RemiseOrdreEventDto(String reference, LocalDateTime timestamp, Event.Canal canal, LocalDateTime activityTime, String username, String bankCode, String countryCode, String segment, LocationDto location, ContratDto contrat, DeviceDto device, String motif) {
        super(reference, timestamp, canal, activityTime, username, bankCode, countryCode, segment, location, contrat, device, motif);
    }

}
