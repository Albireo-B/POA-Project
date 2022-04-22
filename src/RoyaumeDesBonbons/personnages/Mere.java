package RoyaumeDesBonbons.personnages;

import RoyaumeDesBonbons.error.AllergieException;
import RoyaumeDesBonbons.bonbon.Bonbon;
import RoyaumeDesBonbons.bonbon.Ingredient;
import RoyaumeDesBonbons.error.PoolEmptyException;
import RoyaumeDesBonbons.error.PoolIngredientException;

import java.util.Collections;
import java.util.List;

final class Mere {
    Bonbon passerCommandePourEnfant(String nomBonbon, List<Ingredient> allergiesEnfant) throws AllergieException, PoolIngredientException {
        Bonbon bonbon = RoiDesBonbons.getInstance().SouhaitBonbon(nomBonbon);
        List<Ingredient> ingredientsBonbon = bonbon.getIngredients();


        if (Collections.disjoint(ingredientsBonbon, allergiesEnfant)) {
            return bonbon;
        } else {
            throw new AllergieException("l'enfant ne peut pas manger " + bonbon + " car il y est allergique.");
        }
    }

}
