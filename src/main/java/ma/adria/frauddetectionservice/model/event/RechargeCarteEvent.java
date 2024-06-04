package ma.adria.frauddetectionservice.model.event;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ma.adria.frauddetectionservice.model.Account;
import ma.adria.frauddetectionservice.model.Event;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "rechargeCarte_event")
@SuperBuilder
public class RechargeCarteEvent extends Event {
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;
    @OneToOne(cascade = CascadeType.ALL)
    private Account debitorAccount;
    @OneToOne(cascade = CascadeType.ALL)
    private Account creditorAccount;
    private String numCard;
    private String typeRecharge;
    private LocalDateTime dateExecution;
    private BigDecimal montant;
    private String devise;
    private String motif;
    @Enumerated(EnumType.STRING)
    private RechargeCarteStatus status;

    public enum RechargeCarteStatus {
        SUCCES, FAILED

    }


}
