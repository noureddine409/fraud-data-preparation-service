package ma.adria.frauddetectionservice.model;

import ma.adria.frauddetectionservice.enums.Status;

import java.time.LocalDateTime;

public class DemandeLCN extends DemandeService{
    private int nomberLCN;
    private String typeLCN;
    private String devise;
    private LocalDateTime dateEnvoie;

}
