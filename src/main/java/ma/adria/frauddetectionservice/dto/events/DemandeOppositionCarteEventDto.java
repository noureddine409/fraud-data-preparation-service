package ma.adria.frauddetectionservice.dto.events;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ma.adria.frauddetectionservice.common.CoreConstants;
import ma.adria.frauddetectionservice.model.event.DemandeOppositionCarteEvent;
import ma.adria.frauddetectionservice.dto.AccountDto;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class DemandeOppositionCarteEventDto extends EventDto {
    private AccountDto account;
    private String motif;
    private LocalDateTime datePerte;
    private LocalDateTime dateEnvoie;
    private DemandeOppositionCarteEvent.DemandeOppositionCarteStatus status;

    @Override
    public String getEventName() {
        return CoreConstants.EventNames.DEMANDE_OPPOSITION_CARTE;
    }

}
