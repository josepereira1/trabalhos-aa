package pt.uminho.di.aa;

public class GameExistsException extends Exception {
    public GameExistsException(){
        super();
    }

    public GameExistsException(String msg){
        super(msg);
    }
}
