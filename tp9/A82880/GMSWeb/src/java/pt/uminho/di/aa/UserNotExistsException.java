package pt.uminho.di.aa;

public class UserNotExistsException extends Exception {
    public UserNotExistsException(){
        super();
    }

    public UserNotExistsException(String msg){
        super(msg);
    }
}
