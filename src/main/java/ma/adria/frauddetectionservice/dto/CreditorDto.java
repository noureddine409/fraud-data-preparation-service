package ma.adria.frauddetectionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.adria.frauddetectionservice.model.Creditor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditorDto {
    private Creditor creditor;

}
