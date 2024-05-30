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
@Table(name = "payementFacture_event")
public class PayementFactureEvent extends Event {
    private String creancier;
    private String creance;
    private String intituleClient;
    @OneToOne(cascade = CascadeType.ALL)
    private Account compteDebitor;
    private LocalDateTime dateCreation;
    private LocalDateTime dateEnvoie;
    private String amount;
    @Enumerated(EnumType.STRING)
    private StatusPayementFactureEvent statusPayementFactureEvent;
    @OneToOne(cascade = CascadeType.ALL)
    private Account compteDebit;
    public enum StatusPayementFactureEvent {
        SUCCES, FAILED

    }


}
