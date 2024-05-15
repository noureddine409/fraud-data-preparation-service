package ma.adria.frauddetectionservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GeolocationDto {
    private float longitude;
    private float latitude;
}
