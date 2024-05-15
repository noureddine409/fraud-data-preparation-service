package ma.adria.frauddetectionservice.model;

import jakarta.persistence.*;
import lombok.*;
import ma.adria.frauddetectionservice.enums.Status;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "authentification")
public class Authentification extends Event{
    private String reference;
    private String eventActor;
    @Enumerated(EnumType.STRING)
    private Status status;


}
