package ma.adria.frauddetectionservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeviceDto {
    private String deviceId;
    private String deviceType;

    private String macAddress;
    private String browser;
    private String browserVersion;
    private String os;
    private String manufacturer;
    private String model;

}
