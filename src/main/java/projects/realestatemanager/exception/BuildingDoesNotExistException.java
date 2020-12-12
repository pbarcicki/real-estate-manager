package projects.realestatemanager.exception;

public class BuildingDoesNotExistException extends RuntimeException {
    public BuildingDoesNotExistException(String message)  {
        super(message);
    }
}
