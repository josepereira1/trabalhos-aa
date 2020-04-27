package pt.uminho.di.aa;

public class GameNotExistsException extends Exception {
    public GameNotExistsException(){
        super();
    }

    public GameNotExistsException(String msg){
        super(msg);
    }
}
