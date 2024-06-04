package ma.adria.frauddetectionservice.dto.events;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.adria.frauddetectionservice.common.CoreConstants;
import ma.adria.frauddetectionservice.dto.AccountDto;
import ma.adria.frauddetectionservice.model.event.RemiseOrdreEvent;

@Getter
@Setter
@ToString(callSuper = true)
public class RemiseOrdreEventDto extends EventDto {
    private String natureRemise;
    private String FormatRemiseOrdre;
    private String donneurOrdre;
    private AccountDto compteDebit;
    private String fichier;
    private RemiseOrdreEvent.AjouterRemiseStatus status;

    @Override
    public String getEventName() {
        return CoreConstants.EventNames.REMISE_ORDRE;
    }

}
