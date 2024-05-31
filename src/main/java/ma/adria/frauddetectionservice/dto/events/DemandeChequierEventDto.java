package ma.adria.frauddetectionservice.dto.events;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.adria.frauddetectionservice.common.CoreConstants;
import ma.adria.frauddetectionservice.model.event.DemandeChequierEvent;
import ma.adria.frauddetectionservice.dto.AccountDto;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)

public class DemandeChequierEventDto extends EventDto{
    private String idContrat;
    private AccountDto account;
    private int nombreCheqquier;
    private String typeChequier;
    private String devise;
    private LocalDateTime dateEnvoie;
    private DemandeChequierEvent.DemandeChequierStatus demandeChequierStatus;

    @Override
    public String getEventName() {
        return CoreConstants.EventNames.DEMANDE_CHEQUIER;
    }
}
