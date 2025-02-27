package ma.adria.frauddetectionservice.model.event;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ma.adria.frauddetectionservice.model.Account;
import ma.adria.frauddetectionservice.model.BeneficiaryInfo;
import ma.adria.frauddetectionservice.model.Event;
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "gestionBenificiaire_event")
@SuperBuilder
public class BeneficiaryInfoEvent extends Event {
    private String action;
    @OneToOne(cascade = CascadeType.ALL)
    private BeneficiaryInfo beneficiaryInfo;
    @OneToOne(cascade = CascadeType.ALL)
    private Account compteDebitor;
}
