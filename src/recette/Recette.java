package recette;

import bonbon.Ingredient;
import error.PoolIngredientException;
import operation.Operation;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Recette {

    public AbstractMap<Ingredient, Integer> ingredients;
    public ArrayList<Operation> operations;


    public ArrayList<Operation> GetOperations() {
        return operations;
    }

    ;

    public AbstractMap<Ingredient, Integer> GetIngredients() {
        return ingredients;
    }

    ;

    Recette() throws PoolIngredientException {
        ingredients = new HashMap<Ingredient, Integer>();
        operations = new ArrayList<Operation>();
    }

    @Override
    public String toString() {
        StringBuilder recette = new StringBuilder();
        recette.append(this.getClass().getName().substring(this.getClass().getName().indexOf(".") + 1) + " { \n   Ingredients : ");

        ingredients.forEach((ingredient, integer) ->
                recette.append("\n          " + ingredient.GetNom() + ", quantité : " + integer));

        recette.append("\n  Opérations : ");

        operations.forEach(operation ->
                recette.append("\n          " + operation.toString()));

        recette.append("\n}");

        return recette.toString();
    }
}
