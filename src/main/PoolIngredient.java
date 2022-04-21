package main;

import error.NoIngredientException;
import error.PoolEmptyException;

import java.util.*;

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

    public Ingredient PrendreIngredientAuHasard() throws PoolEmptyException {
        ArrayList<Ingredient> ingredientsAvailable = new ArrayList<>();
        ingredients.forEach((key, val)->{
            if(val>0){
                ingredientsAvailable.add(key);
            }
        });
        if(ingredientsAvailable.size()==0){
            throw new PoolEmptyException("Il n'y a plus d'ingrédient disponible");
        }

        int indexRandomIngredient = (int)(Math.floor(Math.random())*10) % ingredientsAvailable.size();
        Ingredient randomIngredient = ingredientsAvailable.get(indexRandomIngredient);
        return randomIngredient;
    }

    private ArrayList<String> GetListIngredients(){
        ArrayList<String> listIngredients = new ArrayList<>();
        ingredients.forEach((key, val)->{
            listIngredients.add(key.GetNom());
        });
        return listIngredients;
    }
}
