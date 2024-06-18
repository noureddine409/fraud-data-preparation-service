package ma.adria.frauddetectionservice.dto.events;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ma.adria.frauddetectionservice.common.CoreConstants;
import ma.adria.frauddetectionservice.dto.CreditorDto;

import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class MutipleVirementEventDto extends VirementDto{
    private int nombreOperations;
    private List<CreditorDto> creditors ;

    @Override
    public String getEventName() {
        return CoreConstants.EventNames.MULTIPLE_VIREMENT;
    }

}
