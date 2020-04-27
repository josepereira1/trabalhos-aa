package pt.uminho.di.aa;

public class InvalidParametersException extends Exception {
    public InvalidParametersException(){
        super();
    }

    public InvalidParametersException(String msg){
        super(msg);
    }
}
