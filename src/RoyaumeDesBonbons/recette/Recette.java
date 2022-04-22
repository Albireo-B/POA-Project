package RoyaumeDesBonbons.recette;

import RoyaumeDesBonbons.bonbon.Ingredient;
import RoyaumeDesBonbons.operation.Operation;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Recette {

    protected AbstractMap<Ingredient, Integer> ingredients;
    protected ArrayList<Operation> operations;


    Recette() {
        ingredients = new HashMap<Ingredient, Integer>();
        operations = new ArrayList<Operation>();
    }

    public AbstractMap<Ingredient, Integer> getIngredients() {
        return new HashMap<>(ingredients);
    }

    public  ArrayList<Operation> getOperations() {
        return new ArrayList<>(operations);
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
