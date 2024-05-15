package ma.adria.frauddetectionservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "geolocation")
public class Geolocation extends BaseEntity{
    private float longitude;
    private float latitude;
}
