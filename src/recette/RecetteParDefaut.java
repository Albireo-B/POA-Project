package recette;

import bonbon.Ingredient;
import error.PoolIngredientException;
import bonbon.PoolIngredient;
import operation.OperationBrasser;
import operation.OperationEmballer;

import java.util.Map;

public class RecetteParDefaut extends Recette {

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
