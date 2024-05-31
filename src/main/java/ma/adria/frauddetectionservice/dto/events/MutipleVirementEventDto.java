package ma.adria.frauddetectionservice.dto.events;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.adria.frauddetectionservice.common.CoreConstants;
import ma.adria.frauddetectionservice.dto.CreditorDto;

import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
public class MutipleVirementEventDto extends EventDto{
    private int nombreOperations;
    private List<CreditorDto> creditors ;

    @Override
    public String getEventName() {
        return CoreConstants.EventNames.MULTIPLE_VIREMENT;
    }

}
