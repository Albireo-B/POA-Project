package personnages;

import bonbon.Bonbon;
import bonbon.Ingredient;
import error.AllergieException;

import java.util.Collections;
import java.util.List;

public final class Mere {
    Bonbon passerCommandePourEnfant(String nomBonbon, List<Ingredient> allergiesEnfant) throws AllergieException {
        Bonbon bonbon = RoiDesBonbons.getInstance().SouhaitBonbon(nomBonbon);
        List<Ingredient> ingredientsBonbon = bonbon.getIngredients();


        if (Collections.disjoint(ingredientsBonbon, allergiesEnfant)) {
            return bonbon;
        } else {
            throw new AllergieException("l'enfant ne peut pas manger " + bonbon.toString() + " car il y est allergique.");
        }
    }

}
