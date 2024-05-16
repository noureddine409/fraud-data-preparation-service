package ma.adria.frauddetectionservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "remiseOrdre_event")
public class RemiseOrdreEvent extends Event {
    private String natureRemise;
    private String FormatRemiseOrdre;
    private String donneurOrdre;
    @OneToOne(cascade = CascadeType.ALL)
    private Account compteDebit;
    private String fichier;
    @Enumerated(EnumType.STRING)
    private AjouterRemiseStatus status;

    public enum AjouterRemiseStatus {
        SUCCES, FAILED
    }


}
