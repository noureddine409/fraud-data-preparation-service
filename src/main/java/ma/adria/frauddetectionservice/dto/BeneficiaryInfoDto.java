package ma.adria.frauddetectionservice.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.adria.frauddetectionservice.model.Account;

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
