package ma.adria.frauddetectionservice.dto.events;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ma.adria.frauddetectionservice.common.CoreConstants;
import ma.adria.frauddetectionservice.dto.CreditorDto;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@SuperBuilder
public class AccountToAccountVirementEventDto extends VirementDto {
    private CreditorDto creditor;

    @Override
    public String getEventName() {
        return CoreConstants.EventNames.ACCOUNTOACCOUNT_VIREMENT;
    }
}
