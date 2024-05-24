package ma.adria.frauddetectionservice.dto.EventDto;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import ma.adria.frauddetectionservice.dto.*;
import ma.adria.frauddetectionservice.model.Event;

import java.time.LocalDateTime;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "@eventType"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AuthenticationEventDto.class, name = "AUTHENTICATION"),
        @JsonSubTypes.Type(value = RemiseOrdreEventDto.class, name = "REMISE_ORDRE"),
        @JsonSubTypes.Type(value = PayementFactureEventDto.class, name = "PAYEMENT_FACTURE"),
        @JsonSubTypes.Type(value = CarteTransactionEventDto.class, name = "CARTE_TRANSACTION"),
        @JsonSubTypes.Type(value = BeneficiaryInfoEventDto.class, name = "BENEFICIARY_INFO"),
        @JsonSubTypes.Type(value = AccountToAccountVirementEventDto.class, name = "ACCOUNTOACCOUNT_VIREMENT"),
        @JsonSubTypes.Type(value = ToBeneficiaryVirementEventDto.class, name = "TOBENEFICIARY_VIREMENT"),
        @JsonSubTypes.Type(value = MutipleVirementEventDto.class, name = "MULTIPLE_VIREMENT"),
        @JsonSubTypes.Type(value = DemandeChequierEventDto.class, name = "DEMANDE_CHEQUIER")








})
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public abstract class EventDto {
    private String reference;
    private LocalDateTime timestamp;
    private Event.Canal canal;
    private LocalDateTime activityTime;
    private String username;
    private String bankCode;
    private String countryCode;
    private String segment;
    private LocationDto location;
    private ContratDto contrat;
    private DeviceDto device;
    private String motif;


}
