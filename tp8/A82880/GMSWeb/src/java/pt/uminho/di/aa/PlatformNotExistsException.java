package pt.uminho.di.aa;

public class PlatformNotExistsException extends Exception {
    public PlatformNotExistsException(){
        super();
    }

    public PlatformNotExistsException(String msg){
        super(msg);
    }
}
