package ma.adria.frauddetectionservice.model.event;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ma.adria.frauddetectionservice.model.Account;
import ma.adria.frauddetectionservice.model.Event;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "carteTransaction_event")
@SuperBuilder
public class CarteTransactionEvent extends Event {
    private String cardNumber;
    private String libelleOperation;
    private String dateOperation;
    private String devise;
    private String montant;
    @Enumerated(EnumType.STRING)
    private CarteTransactionType carteTransactionType;
    @Enumerated(EnumType.STRING)
    private TransationType transationType;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "compte_debit_id", unique = true)
    private Account compteDebit;
    public enum CarteTransactionType {
        TPE, GAB, E_COMMERCE    }
    public enum TransationType {
        DEBIT, CREDIT
    }


}
