package ma.adria.frauddetectionservice.dto.events;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ma.adria.frauddetectionservice.dto.ExecutionFrequencyDto;
import ma.adria.frauddetectionservice.model.Virement;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class VirementDto extends EventDto {
    private Virement.ExecutionDateType type;
    private String currency;
    private ExecutionFrequencyDto executionFrequency;
}
