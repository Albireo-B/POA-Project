package error;

public class AllergieException extends Exception {
    public AllergieException(String message) {
        super("AllergieException : " + message);
    }
}
