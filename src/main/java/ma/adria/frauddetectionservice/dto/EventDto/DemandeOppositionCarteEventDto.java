package ma.adria.frauddetectionservice.dto.EventDto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.adria.frauddetectionservice.Event.DemandeOppositionCarteEvent;
import ma.adria.frauddetectionservice.dto.AccountDto;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
public class DemandeOppositionCarteEventDto extends EventDto {
    private AccountDto account;
    private String motif;
    private LocalDateTime datePerte;
    private LocalDateTime dateEnvoie;
    private DemandeOppositionCarteEvent.DemandeOppositionCarteStatus status;

}
