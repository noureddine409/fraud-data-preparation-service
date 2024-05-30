package ma.adria.frauddetectionservice.Event;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ma.adria.frauddetectionservice.model.Account;
import ma.adria.frauddetectionservice.model.Event;
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "demandeRecalculCodePin_event")
public class DemandeRecalculCodePinEvent extends Event {
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;
    private String motif;
    private String carteId;
    @Enumerated(EnumType.STRING)
    private TransferMode modeEnvoie;
    @Enumerated(EnumType.STRING)
    private DemandeRecalculCodePinStatus status;

    public enum DemandeRecalculCodePinStatus{
        SUCCES, FAILED
    }

    public enum TransferMode {
        SMS, EMAIL
    }


}