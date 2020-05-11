package pt.uminho.di.aa;

public class PlatformExistsException extends Exception {
    public PlatformExistsException(){
        super();
    }

    public PlatformExistsException(String msg){
        super(msg);
    }
}
