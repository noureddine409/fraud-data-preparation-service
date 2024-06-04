package ma.adria.frauddetectionservice.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@SuperBuilder
public class FraudCheckResult extends BaseEntity {
    private String ruleName;

    private boolean fraud;
    private String reason;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "event_id", nullable = false, insertable = false, updatable = false)
    private Event event;

}
