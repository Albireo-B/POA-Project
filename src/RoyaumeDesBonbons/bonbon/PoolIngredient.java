package RoyaumeDesBonbons.bonbon;

import RoyaumeDesBonbons.error.NoIngredientException;
import RoyaumeDesBonbons.error.PoolEmptyException;
import RoyaumeDesBonbons.error.PoolIngredientException;

import java.util.*;

public final class PoolIngredient {

    private static PoolIngredient instance = null;
    private final AbstractMap<Ingredient, Integer> ingredients;


    private PoolIngredient() {
        ingredients = new HashMap<Ingredient, Integer>();
        ajouterIngredient(new Ingredient("Sucre"), 500);
        ajouterIngredient(new Ingredient("Gélatine"), 500);
        ajouterIngredient(new Ingredient("Pomme"), 300);
        ajouterIngredient(new Ingredient("Poire"), 300);
        ajouterIngredient(new Ingredient("Banane"), 300);
        ajouterIngredient(new Ingredient("Anis"), 300);
        ajouterIngredient(new Ingredient("Colorant"), 300);
        ajouterIngredient(new Ingredient("Sucre acidulé"), 300);
    }

    public static PoolIngredient getInstance() {
        if (instance == null)
            instance = new PoolIngredient();

        return instance;
    }

    private void ajouterIngredient(Ingredient ingredient, int quantite) {
        ingredients.put(ingredient, quantite);
    }

    private boolean IngredientDisponible(Ingredient ingredient) {
        return ingredients.containsKey(ingredient);
    }

    public boolean ingredientQuantiteDisponible(Ingredient ingredient, int quantite) {
        if(ingredients.containsKey(ingredient)){
            if(ingredients.get(ingredient) >= quantite) {
                return true;
            }
        }
        return false;
    }

    public Map.Entry<Ingredient, Integer> PrendreIngredient(Ingredient ingredient, Integer quantite) throws NoIngredientException {
        if (!IngredientDisponible(ingredient)) {
            throw new NoIngredientException("L'ingrédient n'est pas disponible");
        }
        int quantiteReserve = ingredients.get(ingredient);
        if (quantiteReserve < quantite) {
            throw new NoIngredientException(
                    "La quantité voulue (" + quantite + ") est supérieure à la quantité restante (" + quantiteReserve + ")"
            );
        }

        ingredients.compute(ingredient, (key, val) -> val - quantite);
        return Map.entry(ingredient, quantite);
    }

    public Ingredient GetIngredient(String ingredientClass) {
        for (Ingredient ingredient : ingredients.keySet()) {
            if (ingredient.GetNom().equals(ingredientClass)) {
                return ingredient;
            }
        }
        return null;
    }

    public Map.Entry<Ingredient, Integer> PrendreIngredientAuHasard(int value) throws PoolIngredientException {
        ArrayList<Ingredient> ingredientsAvailable = new ArrayList<>();
        ingredients.forEach((key, val) -> {
            if (val >= value) {
                ingredientsAvailable.add(key);
            }
        });

        if (ingredientsAvailable.size() == 0) {
            throw new PoolEmptyException("Il n'y a plus d'ingrédient disponible");
        }

        int indexRandomIngredient = (int) (Math.floor(Math.random() * 10)) % ingredientsAvailable.size();
        Ingredient randomIngredient = ingredientsAvailable.get(indexRandomIngredient);

        PrendreIngredient(randomIngredient, value);

        return Map.entry(randomIngredient, value);
    }

    public boolean IsEmpty(int deltaQuantity) {
        ArrayList<Ingredient> ingredientsAvailable = new ArrayList<>();
        ingredients.forEach((key, val) -> {
            if (val >= deltaQuantity) {
                ingredientsAvailable.add(key);
            }
        });
        return !(ingredientsAvailable.size() > 2);
    }
}
