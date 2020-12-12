package projects.realestatemanager.exception;

public class BuildingAlreadyExistsException extends RuntimeException {
    public BuildingAlreadyExistsException(String message) {
        super(message);
    }
}
