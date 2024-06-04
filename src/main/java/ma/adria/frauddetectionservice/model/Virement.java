package ma.adria.frauddetectionservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
public class Virement extends Event {
    @Enumerated(EnumType.STRING)
    private ExecutionDateType type;
    private String curency;//devise
    @OneToOne(cascade = CascadeType.ALL)
    private ExecutionFrequency executionFrequency;


    public enum ExecutionDateType {
        Immediate, Deferred, Permanent
    }
}
