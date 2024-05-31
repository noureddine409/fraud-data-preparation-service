package ma.adria.frauddetectionservice.dto.events;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.adria.frauddetectionservice.common.CoreConstants;
import ma.adria.frauddetectionservice.dto.BeneficiaryInfoDto;

@Getter
@Setter
@ToString(callSuper = true)

public class BeneficiaryInfoEventDto extends EventDto {
    private String action;
    private BeneficiaryInfoDto beneficiaryInfo;


    @Override
    public String getEventName() {
        return CoreConstants.EventNames.BENEFICIARY_INFO;
    }
}
