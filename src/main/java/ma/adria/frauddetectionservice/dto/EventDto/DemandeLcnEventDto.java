package ma.adria.frauddetectionservice.dto.EventDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.adria.frauddetectionservice.model.event.DemandeLcnEvent;
import ma.adria.frauddetectionservice.dto.AccountDto;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
public class DemandeLcnEventDto extends EventDto{
    private int nombreLCN;
    private AccountDto account;
    private String typeLCN;
    private String devise;
    private LocalDateTime dateEnvoie;
    private DemandeLcnEvent.DemandeLcnStatus status;


}
