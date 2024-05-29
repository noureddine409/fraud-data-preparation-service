package ma.adria.frauddetectionservice.dto.EventDto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.adria.frauddetectionservice.Event.DemandeRecalculCodePinEvent;
import ma.adria.frauddetectionservice.dto.AccountDto;

@Getter
@Setter
@ToString(callSuper = true)
public class DemandeRecalculCodePinEventDto extends EventDto{
    private AccountDto account;
    private String motif;
    private String carteId;
    private DemandeRecalculCodePinEvent.TransferMode modeEnvoie;
    private DemandeRecalculCodePinEvent.DemandeRecalculCodePinStatus status;



}
