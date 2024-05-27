package ma.adria.frauddetectionservice.dto.EventDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.adria.frauddetectionservice.dto.CreditorDto;
import ma.adria.frauddetectionservice.dto.ExecutionFrequencyDto;
import ma.adria.frauddetectionservice.model.Creditor;
import ma.adria.frauddetectionservice.model.Virement;

@Getter
@Setter
@ToString(callSuper = true)
public class AccountToAccountVirementEventDto extends EventDto{
    private CreditorDto creditor;


}
