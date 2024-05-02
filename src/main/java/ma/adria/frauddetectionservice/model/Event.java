package ma.adria.frauddetectionservice.model;

public abstract class Event extends BaseEntity{
     private Contrat contrat;
     private String Motif;
     private DeviceInfo deviceInfo;
     private Location location;
     private Canal canal;
    private ClientSegment segment;
    private String username;
    private EventActor eventActor;
    private EventStatus status;


}
