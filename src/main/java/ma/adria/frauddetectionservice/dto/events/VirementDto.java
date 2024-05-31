package ma.adria.frauddetectionservice.dto.events;

import lombok.*;
import ma.adria.frauddetectionservice.model.ExecutionFrequency;
import ma.adria.frauddetectionservice.model.Virement;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public abstract class VirementDto {
    private Virement.ExecutionDateType type;
    private String reason;
    private String curency;
    private ExecutionFrequency executionFrequency;
}
