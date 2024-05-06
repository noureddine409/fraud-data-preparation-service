package ma.adria.frauddetectionservice.model;


import ma.adria.frauddetectionservice.enums.Canal;
import ma.adria.frauddetectionservice.enums.ClientSegment;
import ma.adria.frauddetectionservice.enums.Status;


public abstract class Event extends BaseEntity{
    private String reference;
    private Contrat contrat;
     private String Motif;
     private DeviceInfo deviceInfo;
     private Location location;
     private Canal canal;
    private ClientSegment segment;
    private String username;
    private EventActor eventActor;
    private Status status;


}
