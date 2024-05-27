package ma.adria.frauddetectionservice.dto.EventDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.adria.frauddetectionservice.dto.CreditorDto;

@Getter
@Setter
@ToString(callSuper = true)

public class ToBeneficiaryVirementEventDto extends EventDto{
    private CreditorDto creditor;

}
