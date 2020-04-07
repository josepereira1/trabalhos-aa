package pt.uminho.di.aa;

public class FormatAlreadyExistsException extends Exception {
    public FormatAlreadyExistsException(String kind) {
        super(kind);
    }
}
