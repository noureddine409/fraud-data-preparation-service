package ma.adria.frauddetectionservice.dispatcher;

public class EventHandlerNotFoundException extends RuntimeException {
    public EventHandlerNotFoundException(String message) {
        super(message);
    }
}
