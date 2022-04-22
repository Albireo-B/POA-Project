package recette;

import error.NoIngredientException;
import error.PoolIngredientException;
import main.Ingredient;
import main.PoolIngredient;
import operation.OperationBrasser;
import operation.OperationEmballer;
import operation.OperationPeser;

import java.util.Map;

public class RecetteParDefaut  extends Recette {

    public RecetteParDefaut() throws PoolIngredientException{
        super();
        //On choisit les ingrédients présents dans la recette
        PoolIngredient poolIngredient = PoolIngredient.getInstance();
        for(int i = 0; i<3; i++){
            Map.Entry<Ingredient, Integer> ingredientQuantity = poolIngredient.PrendreIngredientAuHasard(10);
            ingredients.put(
                    ingredientQuantity.getKey(),
                    10);
        }

        operations.add(new OperationBrasser());
        operations.add(new OperationEmballer());
    }

}
