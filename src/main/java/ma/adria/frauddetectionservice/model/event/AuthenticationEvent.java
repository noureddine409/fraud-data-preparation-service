package ma.adria.frauddetectionservice.model.event;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ma.adria.frauddetectionservice.model.Contrat;
import ma.adria.frauddetectionservice.model.Device;
import ma.adria.frauddetectionservice.model.Event;
import ma.adria.frauddetectionservice.model.Location;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "authentication_event")
@SuperBuilder
public class AuthenticationEvent extends Event {
}
