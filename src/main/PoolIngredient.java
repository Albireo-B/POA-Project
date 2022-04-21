package main;

import error.NoIngredientException;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class PoolIngredient {

    private static PoolIngredient instance = null;
    private AbstractMap<Ingredient,Integer> ingredients;


    private PoolIngredient(){
        ingredients = new HashMap<Ingredient, Integer>();
        ingredients.put(new Ingredient("Sucre"), 500);
        ingredients.put(new Ingredient("Gélatine"), 500);
        ingredients.put(new Ingredient("Pomme"), 200);
        ingredients.put(new Ingredient("Poire"), 200);
        ingredients.put(new Ingredient("Banane"), 200);
        ingredients.put(new Ingredient("Anis"), 200);
        ingredients.put(new Ingredient("Colorant"), 200);
        ingredients.put(new Ingredient("Sucre acidulé"), 300);
    }

    public static PoolIngredient getInstance()
    {
        if (instance == null)
            instance = new PoolIngredient();

        return instance;
    }

    public boolean IngredientDisponible(Ingredient ingredient){
        return ingredients.containsKey(ingredient);
    }

    public void PrendreIngredient(Ingredient ingredient, Integer quantite) throws NoIngredientException {
        if(!IngredientDisponible(ingredient)){ throw new NoIngredientException("L'ingrédient n'est pas disponible"); }
        int quantiteReserve = ingredients.get(ingredient);
        if(quantiteReserve < quantite){
            throw new NoIngredientException(
                    "La quantité voulue ("+quantite+") est supérieure à la quantité restante ("+quantiteReserve+")"
            );
        }

        ingredients.compute(ingredient, (key, val) -> val - quantite);
    }
}
