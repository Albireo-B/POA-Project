package main;

import java.util.ArrayList;

public class Bonbon {

    private String nom;
    private ArrayList<Ingredient> ingredients;

    public Bonbon(String nomBonbon){

        nom = nomBonbon;
        ingredients = new ArrayList<Ingredient>();
    }

    public void AjouterIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
    }

    @Override
    public String toString(){
        return "Bonbon : {\n    Nom : " + nom + "\n    Ingredients : " + ingredients.toString() + "\n}";
    }
}
