package ma.adria.frauddetectionservice.dto.events;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ma.adria.frauddetectionservice.common.CoreConstants;
import ma.adria.frauddetectionservice.model.event.DemandeRecalculCodePinEvent;
import ma.adria.frauddetectionservice.dto.AccountDto;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
public class DemandeRecalculCodePinEventDto extends EventDto{
    private AccountDto account;
    private String motif;
    private String carteId;
    private DemandeRecalculCodePinEvent.TransferMode modeEnvoie;
    private DemandeRecalculCodePinEvent.DemandeRecalculCodePinStatus status;

    @Override
    public String getEventName() {
        return CoreConstants.EventNames.DEMANDE_RECALCUL_CODE_PIN;
    }

}
