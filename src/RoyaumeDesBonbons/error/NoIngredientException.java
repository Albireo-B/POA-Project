package RoyaumeDesBonbons.error;

public final class NoIngredientException extends PoolIngredientException {

    public NoIngredientException(String message) {
        super("NoIngredientException : " + message);
    }
}
