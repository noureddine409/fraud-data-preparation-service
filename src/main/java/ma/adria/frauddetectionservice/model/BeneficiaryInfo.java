package ma.adria.frauddetectionservice.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "beneficiaryInfo")
@SuperBuilder
public class BeneficiaryInfo extends BaseEntity{
    private String nature;
    private String type;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;
}
