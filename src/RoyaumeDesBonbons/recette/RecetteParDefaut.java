package RoyaumeDesBonbons.recette;

import RoyaumeDesBonbons.bonbon.Ingredient;
import RoyaumeDesBonbons.error.PoolIngredientException;
import RoyaumeDesBonbons.bonbon.PoolIngredient;
import RoyaumeDesBonbons.operation.OperationBrasser;
import RoyaumeDesBonbons.operation.OperationEmballer;

import java.util.Map;

public final class RecetteParDefaut extends Recette {

    public RecetteParDefaut() throws PoolIngredientException {
        super();
        //On choisit les ingrédients présents dans la recette
        PoolIngredient poolIngredient = PoolIngredient.getInstance();
        for (int i = 0; i < 3; i++) {
            Map.Entry<Ingredient, Integer> ingredientQuantity = poolIngredient.PrendreIngredientAuHasard(10);
            ingredients.put(
                    ingredientQuantity.getKey(),
                    10);
        }

        operations.add(new OperationBrasser());
        operations.add(new OperationEmballer());
    }

}
