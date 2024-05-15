package ma.adria.frauddetectionservice.model;

import jakarta.persistence.*;
import lombok.*;
import ma.adria.frauddetectionservice.dto.GeolocationDto;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "location")
public class Location extends BaseEntity{
    private String ipAddress;
    private String ipAddress2;
    @ManyToOne
    private Geolocation geolocation;
}
