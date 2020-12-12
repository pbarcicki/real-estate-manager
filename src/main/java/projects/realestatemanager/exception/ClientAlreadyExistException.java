package projects.realestatemanager.exception;

public class ClientAlreadyExistException extends RuntimeException{
    public ClientAlreadyExistException(String message){
        super(message);
    }
}
