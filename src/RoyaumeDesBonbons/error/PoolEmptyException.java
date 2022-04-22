package RoyaumeDesBonbons.error;

public final class PoolEmptyException extends PoolIngredientException {

    public PoolEmptyException(String message) {
        super("PoolEmptyException : " + message);
    }

}
