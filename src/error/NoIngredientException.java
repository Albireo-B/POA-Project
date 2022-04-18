package error;

public class NoIngredientException extends Exception{

    public NoIngredientException(String message){
        super("NoIngredientException : " + message);
    }
}
