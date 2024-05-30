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
@Table(name = "DemandeOppositionCarte_event")

public class DemandeOppositionCarteEvent extends Event {
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;
    private String motif;
    private LocalDateTime datePerte;
    private LocalDateTime dateEnvoie;
    @Enumerated(EnumType.STRING)
    private DemandeOppositionCarteStatus status;

    public enum DemandeOppositionCarteStatus{
        SUCCES, FAILED
    }
}
