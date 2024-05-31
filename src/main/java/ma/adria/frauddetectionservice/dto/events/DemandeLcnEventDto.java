package ma.adria.frauddetectionservice.dto.events;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.adria.frauddetectionservice.common.CoreConstants;
import ma.adria.frauddetectionservice.model.event.DemandeLcnEvent;
import ma.adria.frauddetectionservice.dto.AccountDto;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
public class DemandeLcnEventDto extends EventDto{
    private int nombreLcn;
    private AccountDto account;
    private String typeLcn;
    private String devise;
    private LocalDateTime dateEnvoie;
    private DemandeLcnEvent.DemandeLcnStatus status;

    @Override
    public String getEventName() {
        return CoreConstants.EventNames.DEMANDE_LCN;
    }
}
