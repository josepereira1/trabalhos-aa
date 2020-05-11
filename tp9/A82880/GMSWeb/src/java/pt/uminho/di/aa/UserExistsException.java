package pt.uminho.di.aa;

public class UserExistsException extends Exception {
    public UserExistsException(){
        super();
    }

    public UserExistsException(String msg){
        super(msg);
    }
}
