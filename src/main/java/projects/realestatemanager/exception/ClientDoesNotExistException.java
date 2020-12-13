package projects.realestatemanager.exception;

public class ClientDoesNotExistException extends RuntimeException{
    public ClientDoesNotExistException(String message){
        super(message);
    }
}
