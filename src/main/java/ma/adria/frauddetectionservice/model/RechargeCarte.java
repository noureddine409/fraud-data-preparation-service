package ma.adria.frauddetectionservice.model;

import ma.adria.frauddetectionservice.enums.RechargeCarteStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RechargeCarte extends DemandeService{
    private Account debitorAccount;
    private Account creditorAccount;
    private String numCard;
    private String typeRecharge;
    private LocalDateTime dateExecution;
    private BigDecimal montant;
    private String devise;
    private String motif;
}
