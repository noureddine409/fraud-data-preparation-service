package ma.adria.frauddetectionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeneficiaryInfoDto {
    private String nature;
    private String type;
    private String name;
    private AccountDto account;

}
