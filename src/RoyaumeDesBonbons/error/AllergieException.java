package RoyaumeDesBonbons.error;

public final class AllergieException extends Exception {
    public AllergieException(String message) {
        super("AllergieException : " + message);
    }
}
