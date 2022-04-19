package main;

import java.util.List;

public class Bonbon {

    private String nom;
    private List<Ingredient> ingredients;

    public Bonbon(String nomBonbon){
        nom = nomBonbon;
    }

    public void AjouterIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
    }
}
