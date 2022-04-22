package error;

public class PoolIngredientException extends Exception {
    public PoolIngredientException(String message) {
        super("PoolIngredientException : " + message);
    }
}
