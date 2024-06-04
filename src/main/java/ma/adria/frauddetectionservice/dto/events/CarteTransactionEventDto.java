package ma.adria.frauddetectionservice.dto.events;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ma.adria.frauddetectionservice.common.CoreConstants;
import ma.adria.frauddetectionservice.dto.AccountDto;
import ma.adria.frauddetectionservice.model.event.CarteTransactionEvent;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
public class CarteTransactionEventDto extends EventDto {
    private String cardNumber;
    private String libelleOperation;
    private String dateOperation;
    private String devise;
    private String montant;
    private CarteTransactionEvent.CarteTransactionType carteTransactionType;
    private CarteTransactionEvent.TransationType transationType;
    private AccountDto compteDebit;

    @Override
    public String getEventName() {
        return CoreConstants.EventNames.CARTE_TRANSACTION;
    }
}
