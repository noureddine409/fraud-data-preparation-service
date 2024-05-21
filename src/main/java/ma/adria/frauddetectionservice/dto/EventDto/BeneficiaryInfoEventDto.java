package ma.adria.frauddetectionservice.dto.EventDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.adria.frauddetectionservice.dto.BeneficiaryInfoDto;

@Getter
@Setter
@ToString(callSuper = true)

public class BeneficiaryInfoEventDto extends EventDto {
    private String action;
    private BeneficiaryInfoDto beneficiaryInfo;
}
