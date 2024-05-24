package ma.adria.frauddetectionservice.dto.EventDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.adria.frauddetectionservice.dto.CreditorDto;

import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
public class MutipleVirementEventDto extends EventDto{
    private int nombreOperations;
    private List<CreditorDto> creditors ;

}
