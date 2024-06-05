package ma.adria.frauddetectionservice.dto.events;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ma.adria.frauddetectionservice.common.CoreConstants;
import ma.adria.frauddetectionservice.model.event.DemandeOppositionChequeEvent;
import ma.adria.frauddetectionservice.dto.AccountDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class DemandeOppositionChequeEventDto extends EventDto{
    private AccountDto account;
    private String Beneficiare;
    private BigDecimal montant;
    private int numeroCheque;
    private int numeroPremierCheque;
    private String declarationPolice;
    private String motif;
    private LocalDateTime datePerte;
    private LocalDateTime dateEnvoie;
    private String statusCheque;
    private DemandeOppositionChequeEvent.DemandeOppositionChequeStatus status;

    @Override
    public String getEventName() {
        return CoreConstants.EventNames.DEMANDE_OPPOSITION_CHEQUE;
    }
}
