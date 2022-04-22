package personnages;

import bonbon.Ingredient;
import error.AllergieException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Enfant {
    private final List<Ingredient> allergies;
    private Mere mere;

    public Enfant(List<String> allergiesStrings) {
        List<Ingredient> allergiesTemp = new ArrayList<Ingredient>();
        allergiesStrings.forEach(nomIngredient -> allergiesTemp.add(new Ingredient(nomIngredient)));
        allergies = Collections.unmodifiableList(allergiesTemp);

        this.setMere(new Mere());
    }


    public void souhaiterPourUnBonBon(String nomBonbon) {
        try {
            mere.passerCommandePourEnfant(nomBonbon, this.allergies);
        } catch (AllergieException e) {
            e.printStackTrace();
        }
    }

    private void setMere(Mere mere) {
        this.mere = mere;
    }

    private void ajouterAllergie(String nomIngredient) {
        this.allergies.add(new Ingredient(nomIngredient));
    }
}
