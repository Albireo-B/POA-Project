package RoyaumeDesBonbons.recette;

import RoyaumeDesBonbons.bonbon.Ingredient;
import RoyaumeDesBonbons.bonbon.PoolIngredient;
import RoyaumeDesBonbons.operation.OperationBrasser;
import RoyaumeDesBonbons.operation.OperationEmballer;

import java.util.Map;

public final class RecetteParDefaut extends Recette {

    public RecetteParDefaut(int quantiteMaximaleParIngredient) {
        super();
        //On choisit les ingrédients présents dans la recette
        PoolIngredient poolIngredient = PoolIngredient.getInstance();
        for (int i = 0; i < 3; i++) {
            Map.Entry<Ingredient, Integer> ingredientSelectionne = poolIngredient.GetIngredientAuHasard(quantiteMaximaleParIngredient);
            ingredients.put(
                    ingredientSelectionne.getKey(),
                    ingredientSelectionne.getValue());
        }

        operations.add(new OperationBrasser());
        operations.add(new OperationEmballer());
    }

}
