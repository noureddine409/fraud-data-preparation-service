package ma.adria.frauddetectionservice.dto.EventDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.adria.frauddetectionservice.Event.CarteTransactionEvent;
import ma.adria.frauddetectionservice.dto.AccountDto;
import ma.adria.frauddetectionservice.dto.ContratDto;
import ma.adria.frauddetectionservice.dto.DeviceDto;
import ma.adria.frauddetectionservice.dto.LocationDto;
import ma.adria.frauddetectionservice.model.Account;
import ma.adria.frauddetectionservice.model.Event;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
public class CarteTransactionEventDto extends EventDto{
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
