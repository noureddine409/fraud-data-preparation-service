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
@Table(name = "device")

public class Device extends BaseEntity{
    private String deviceId;
    private String deviceType;
    private String macAddress;
    private String browser;
    private String browserVersion;
    private String os;
    private String manufacturer;
    private String model;
}
