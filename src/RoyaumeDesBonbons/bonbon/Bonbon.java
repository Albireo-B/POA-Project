package RoyaumeDesBonbons.bonbon;

import java.util.ArrayList;
import java.util.List;

public final class Bonbon {

    private String nom;
    private final ArrayList<Ingredient> ingredients;

    public Bonbon(String nomBonbon) {

        setNom(nomBonbon);
        ingredients = new ArrayList<>();
    }

    public void AjouterIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public List<Ingredient> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    private void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Bonbon : {\n    Nom : " + nom + "\n    Ingredients : " + ingredients.toString() + "\n}";
    }
}
