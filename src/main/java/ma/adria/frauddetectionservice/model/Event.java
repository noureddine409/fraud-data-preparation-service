package ma.adria.frauddetectionservice.model;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.*;
import ma.adria.frauddetectionservice.deserializer.LocalDateTimeDeserializer;
import ma.adria.frauddetectionservice.dto.ContratDto;
import ma.adria.frauddetectionservice.dto.DeviceDto;
import ma.adria.frauddetectionservice.dto.LocationDto;
import ma.adria.frauddetectionservice.enums.Canal;
import ma.adria.frauddetectionservice.enums.ClientSegment;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class Event extends BaseEntity{
    private LocalDateTime timestamp ;
    private Canal canal;
    private LocalDateTime activityTime;
    private String username;
    private String bankCode;
    private String countryCode;
    @Enumerated(EnumType.STRING)
    private ClientSegment segment;
    @OneToOne(cascade = CascadeType.ALL)
    private Location location;
    @ManyToOne(cascade = CascadeType.ALL)
    private Contrat contrat;
    @OneToOne(cascade = CascadeType.ALL)
    private Device device;
    private String motif;
}
