package error;

public class NoIngredientException extends PoolIngredientException{

    public NoIngredientException(String message){
        super("NoIngredientException : " + message);
    }
}
