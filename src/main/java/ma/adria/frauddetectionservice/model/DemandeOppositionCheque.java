package ma.adria.frauddetectionservice.model;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DemandeOppositionCheque extends Event{
    private String Beneficiaire;
    private BigDecimal montant;
    private int numeroCheque;
    private int numeroDernierCheque;
    private String declarationPolice;
    private int numPVPolice;                                                                                                                                                                                                                                                                         n1
    private String motif;
    private LocalDateTime datePerte;
    private LocalDateTime dateEnvoie;
    private String statusCheque;

}
