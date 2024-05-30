package ma.adria.frauddetectionservice.dto.EventDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.adria.frauddetectionservice.model.event.CarteTransactionEvent;
import ma.adria.frauddetectionservice.dto.*;
import ma.adria.frauddetectionservice.model.Event;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
public class CarteTransactionEventDto extends EventDto {
    private String cardNumber;
    private String libelleOperation;
    private String dateOperation;
    private String devise;
    private String montant;
    private CarteTransactionEvent.CarteTransactionType carteTransactionType;
    private CarteTransactionEvent.TransationType transationType;
    private AccountDto compteDebit;
    @Builder
    public CarteTransactionEventDto(String reference, LocalDateTime timestamp, Event.Canal canal, LocalDateTime activityTime, String username, String bankCode, String countryCode, String segment, LocationDto location, ContratDto contrat, DeviceDto device, String motif, String cardNumber) {
        super(reference, timestamp, canal, activityTime, username, bankCode, countryCode, segment, location, contrat, device, motif);
        this.cardNumber = cardNumber;
    }
}
