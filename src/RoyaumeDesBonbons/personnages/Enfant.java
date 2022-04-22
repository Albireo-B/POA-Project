package RoyaumeDesBonbons.personnages;

import RoyaumeDesBonbons.error.AllergieException;
import RoyaumeDesBonbons.bonbon.Ingredient;
import RoyaumeDesBonbons.error.PoolEmptyException;
import RoyaumeDesBonbons.error.PoolIngredientException;

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
        } catch (AllergieException | PoolIngredientException e) {
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
