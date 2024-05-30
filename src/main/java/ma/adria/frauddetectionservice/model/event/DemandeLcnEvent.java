package ma.adria.frauddetectionservice.model.event;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Table(name = "DemandeLcn_event")

public class DemandeLcnEvent extends Event {
    private int nombreLcn;
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;
    private String typeLcn;
    private String devise;
    private LocalDateTime dateEnvoie;
    private DemandeLcnStatus status;

    public enum DemandeLcnStatus {
        SUCCES, FAILED
    }

}
