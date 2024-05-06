package ma.adria.frauddetectionservice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PayementFacture extends Event{
    private String creancier;
    private String creance;
    private String reference;
    private String intituleClient;
    private Account compteDebitor;
    private LocalDateTime dateCreation;
    private LocalDateTime dateEnvoie;
    private BigDecimal amount;
    private String status;

}
