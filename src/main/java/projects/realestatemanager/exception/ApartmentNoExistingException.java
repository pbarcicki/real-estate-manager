package projects.realestatemanager.exception;

public class ApartmentNoExistingException extends RuntimeException {
    public ApartmentNoExistingException(String message) {
        super(message);
    }
}
