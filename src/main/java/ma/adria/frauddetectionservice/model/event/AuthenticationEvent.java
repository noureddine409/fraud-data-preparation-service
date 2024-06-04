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
public class AuthenticationEvent extends Event {
    @Builder(builderMethodName = "authentication_builder")
    public AuthenticationEvent(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String reference, LocalDateTime timestamp, Canal canal, LocalDateTime activityTime, String username, String bankCode, String countryCode, String segment, Location location, Contrat contrat, Device device, String motif) {
        super(id, createdAt, updatedAt, reference, timestamp, canal, activityTime, username, bankCode, countryCode, segment, location, contrat, device, motif);
    }
}
