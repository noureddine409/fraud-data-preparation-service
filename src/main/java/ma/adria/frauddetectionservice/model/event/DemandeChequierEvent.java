package ma.adria.frauddetectionservice.model.event;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ma.adria.frauddetectionservice.model.Account;
import ma.adria.frauddetectionservice.model.Event;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "demandeChequier_event")

public class DemandeChequierEvent extends Event {
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;
    private int nombreCheqquier;
    private String typeChequier;
    private String devise;
    private LocalDateTime dateEnvoie;
    @Enumerated(EnumType.STRING)
    private DemandeChequierStatus demandeChequierStatus;
    public enum DemandeChequierStatus{
        SUCCES, FAILED
    }

}
