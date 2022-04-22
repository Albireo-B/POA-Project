package bonbon;

import java.util.ArrayList;
import java.util.List;

public class Bonbon {

    private String nom;
    private ArrayList<Ingredient> ingredients;

    public Bonbon(String nomBonbon) {

        nom = nomBonbon;
        ingredients = new ArrayList<Ingredient>();
    }

    public void AjouterIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public List<Ingredient> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    @Override
    public String toString() {
        return "Bonbon : {\n    Nom : " + nom + "\n    Ingredients : " + ingredients.toString() + "\n}";
    }
}
