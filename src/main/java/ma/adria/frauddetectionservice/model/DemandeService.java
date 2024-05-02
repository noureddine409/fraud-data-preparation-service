package ma.adria.frauddetectionservice.model;

import ma.adria.frauddetectionservice.enums.Status;

public class DemandeService extends Event{
    private String reference;
    private String idContrat;
    private Account account;
    private Status status;

}
