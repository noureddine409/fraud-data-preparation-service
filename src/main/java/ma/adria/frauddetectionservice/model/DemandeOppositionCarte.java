package ma.adria.frauddetectionservice.model;

import ma.adria.frauddetectionservice.enums.Status;

import java.time.LocalDateTime;

public class DemandeOppositionCarte extends DemandeService{
    private String motif;
    private LocalDateTime datePerte;
    private LocalDateTime dateEnvoie;
}
