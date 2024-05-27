package ma.adria.frauddetectionservice.dto.EventDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.adria.frauddetectionservice.Event.DemandeChequierEvent;
import ma.adria.frauddetectionservice.dto.AccountDto;
import ma.adria.frauddetectionservice.model.Account;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)

public class DemandeChequierEventDto extends EventDto{
    private String idContrat;
    private AccountDto account;
    private int nombreCheqquier;
    private String typeChequier;
    private String devise;
    private LocalDateTime dateEnvoie;
    private DemandeChequierEvent.DemandeChequierStatus demandeChequierStatus;


}
