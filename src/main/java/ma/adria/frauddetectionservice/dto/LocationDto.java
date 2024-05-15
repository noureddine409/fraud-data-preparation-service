package ma.adria.frauddetectionservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LocationDto {
    private String ipAddress;
    private String ipAddress2;
    private GeolocationDto geolocation;
}
