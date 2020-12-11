package projects.realestatemanager.exception;

public class DeveloperAlreadyExistsException extends RuntimeException {
    public DeveloperAlreadyExistsException(String message) {
        super(message);
    }
}