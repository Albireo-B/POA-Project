package main;

import error.NoIngredientException;
import error.PoolEmptyException;
import error.PoolIngredientException;

import java.security.KeyPair;
import java.util.*;

public class PoolIngredient {

    private static PoolIngredient instance = null;
    private AbstractMap<Ingredient,Integer> ingredients;


    private PoolIngredient(){
        ingredients = new HashMap<Ingredient, Integer>();
        ingredients.put(new Ingredient("Sucre"), 500);
        ingredients.put(new Ingredient("Gélatine"), 500);
        ingredients.put(new Ingredient("Pomme"), 300);
        ingredients.put(new Ingredient("Poire"), 300);
        ingredients.put(new Ingredient("Banane"), 300);
        ingredients.put(new Ingredient("Anis"), 300);
        ingredients.put(new Ingredient("Colorant"), 300);
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

    public Map.Entry<Ingredient,Integer> PrendreIngredient(Ingredient ingredient, Integer quantite) throws NoIngredientException {
        if(!IngredientDisponible(ingredient)){ throw new NoIngredientException("L'ingrédient n'est pas disponible"); }
        int quantiteReserve = ingredients.get(ingredient);
        if(quantiteReserve < quantite){
            throw new NoIngredientException(
                    "La quantité voulue ("+quantite+") est supérieure à la quantité restante ("+quantiteReserve+")"
            );
        }

        ingredients.compute(ingredient, (key, val) -> val - quantite);
        return Map.entry(ingredient,quantite);
    }

    public Ingredient GetIngredient(String ingredientClass){
        for (Ingredient ingredient : ingredients.keySet()){
            if (ingredient.GetNom().equals(ingredientClass)){
                return ingredient;
            }
        }
        return null;
    }

    public Map.Entry<Ingredient,Integer> PrendreIngredientAuHasard(int value) throws PoolIngredientException {
        ArrayList<Ingredient> ingredientsAvailable = new ArrayList<>();
        ingredients.forEach((key, val)->{
            if(val>=value){
                ingredientsAvailable.add(key);
            }
        });
        if(ingredientsAvailable.size()==0){
            throw new PoolEmptyException("Il n'y a plus d'ingrédient disponible");
        }

        int indexRandomIngredient = (int)(Math.floor(Math.random()*10)) % ingredientsAvailable.size();
        Ingredient randomIngredient = ingredientsAvailable.get(indexRandomIngredient);

        PrendreIngredient(randomIngredient, value);

        return Map.entry(randomIngredient,value);
    }
}
