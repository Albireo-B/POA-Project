package error;

public class PoolEmptyException extends PoolIngredientException {

    public PoolEmptyException(String message) {
        super("PoolEmptyException : " + message);
    }

}
