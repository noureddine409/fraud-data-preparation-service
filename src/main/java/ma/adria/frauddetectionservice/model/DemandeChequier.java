package ma.adria.frauddetectionservice.model;

import ma.adria.frauddetectionservice.enums.Status;

import java.time.LocalDateTime;

public class DemandeChequier extends DemandeService{
    private int nomberChequier;
    private String typeChequier;
    private String device;
    private LocalDateTime dateEnvoie;

}
