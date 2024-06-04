package ma.adria.frauddetectionservice.dto.events;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ma.adria.frauddetectionservice.common.CoreConstants;
import ma.adria.frauddetectionservice.model.event.RechargeCarteEvent;
import ma.adria.frauddetectionservice.dto.AccountDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
public class RechargeCarteEventDto extends EventDto{
    private AccountDto account;
    private AccountDto debitorAccount;
    private AccountDto creditorAccount;
    private String numCard;
    private String typeRecharge;
    private LocalDateTime dateExecution;
    private BigDecimal montant;
    private String devise;
    private String motif;
    private RechargeCarteEvent.RechargeCarteStatus status;

    @Override
    public String getEventName() {
        return CoreConstants.EventNames.RECHARGE_CARTE;
    }

}
