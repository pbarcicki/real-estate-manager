package projects.realestatemanager.exception;

public class ApartmentAlreadyExistExeption extends RuntimeException {
    public ApartmentAlreadyExistExeption(String message) {
        super(message);
    }
}
