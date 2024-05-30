package ma.adria.frauddetectionservice.dto.EventDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.adria.frauddetectionservice.Event.RechargeCarteEvent;
import ma.adria.frauddetectionservice.dto.AccountDto;
import ma.adria.frauddetectionservice.model.Account;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
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

}
