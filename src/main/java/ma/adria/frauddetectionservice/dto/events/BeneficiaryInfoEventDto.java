package ma.adria.frauddetectionservice.dto.events;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ma.adria.frauddetectionservice.common.CoreConstants;
import ma.adria.frauddetectionservice.dto.BeneficiaryInfoDto;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@SuperBuilder
public class BeneficiaryInfoEventDto extends EventDto {
    private String action;
    private BeneficiaryInfoDto beneficiaryInfo;


    @Override
    public String getEventName() {
        return CoreConstants.EventNames.BENEFICIARY_INFO;
    }
}
