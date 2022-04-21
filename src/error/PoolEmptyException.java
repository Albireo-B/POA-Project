package error;

public class PoolEmptyException extends Exception{
    public PoolEmptyException(String message){
        super("PoolEmptyException : " + message);
    }
}
