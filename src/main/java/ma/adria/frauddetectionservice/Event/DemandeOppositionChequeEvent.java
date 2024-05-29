package ma.adria.frauddetectionservice.Event;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ma.adria.frauddetectionservice.model.Account;
import ma.adria.frauddetectionservice.model.Event;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "DemandeOppositionCheque_event")

public class DemandeOppositionChequeEvent extends Event {
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;
    private String Beneficiare;
    private BigDecimal montant;
    private int numeroCheque;
    private int numeroPremierCheque;
    private String declarationPolice;
    private String motif;
    private LocalDateTime datePerte;
    private LocalDateTime dateEnvoie;
    private String statusCheque;
    @Enumerated(EnumType.STRING)
    private DemandeOppositionChequeStatus status;

    public enum DemandeOppositionChequeStatus {
        SUCCES, FAILED    }
}
