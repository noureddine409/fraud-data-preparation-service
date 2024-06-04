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
@Table(name = "creditor")
@SuperBuilder
public class Creditor extends BaseEntity{
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;
    private String amount;
}
