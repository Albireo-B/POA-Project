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

    public Map.Entry<Ingredient, Integer> GetIngredientAuHasard(int quantiteMaximaleVoulue) {
        ArrayList<Ingredient> ingredientsDisponibles = new ArrayList<>();

        //Rechercher les ingrédients ayant la quantité voulue
        ingredients.forEach((key, val) -> {
            if(val>=quantiteMaximaleVoulue){
                ingredientsDisponibles.add(key);
            }
        });

        //S'il y en a aucun, alors prendre tous ceux qui ne sont pas vide
        if(ingredientsDisponibles.size()==0){
            ingredients.forEach((key, val) -> {
                if(val>0){
                    ingredientsDisponibles.add(key);
                }
            });

            //S'il n'y a vraiment aucune possibilité, alors nous retournons du sucre à une quantité de 10.
            //Si le client voudra prendre physiquement cet ingrédient avec PrendreIngredient(),
            //il ne pourra pas le faire, et il aura une erreur. Donc cela reste sécurisé
            if(ingredientsDisponibles.size()==0){
                return Map.entry(GetIngredient("Sucre"), 10);
            }

            int indexRandomIngredient = (int) (Math.floor(Math.random() * 10)) % ingredientsDisponibles.size();
            Ingredient ingredientSelectionne = ingredientsDisponibles.get(indexRandomIngredient);
            return Map.entry(ingredientSelectionne, ingredients.get(ingredientSelectionne));
        }

        int indexRandomIngredient = (int) (Math.floor(Math.random() * 10)) % ingredientsDisponibles.size();
        Ingredient ingredientSelectionne = ingredientsDisponibles.get(indexRandomIngredient);
        return Map.entry(ingredientSelectionne, quantiteMaximaleVoulue);
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

    @Override
    public String toString(){
        return "PoolIngredient: {\n" + ingredients.toString() + "}\n";
    }
}
