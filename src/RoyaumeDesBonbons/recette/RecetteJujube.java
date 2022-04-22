package RoyaumeDesBonbons.recette;

import RoyaumeDesBonbons.bonbon.Ingredient;
import RoyaumeDesBonbons.error.NoIngredientException;
import RoyaumeDesBonbons.error.PoolIngredientException;
import RoyaumeDesBonbons.bonbon.PoolIngredient;
import RoyaumeDesBonbons.operation.OperationBrasser;
import RoyaumeDesBonbons.operation.OperationEmballer;
import RoyaumeDesBonbons.operation.OperationPeser;

import java.util.AbstractMap;
import java.util.Map;


public final class RecetteJujube extends Recette {

    public RecetteJujube() {
        super();
        //On choisit les ingrédients présents dans la recette
        PoolIngredient poolIngredient = PoolIngredient.getInstance();


        ingredients.put(poolIngredient.GetIngredient("Sucre"), 10);
        ingredients.put(poolIngredient.GetIngredient("Pomme"), 10);
        ingredients.put(poolIngredient.GetIngredient("Gélatine"), 10);
        ingredients.put(poolIngredient.GetIngredient("Colorant"), 10);


        operations.add(new OperationPeser(poolIngredient.GetIngredient("Sucre")));
        operations.add(new OperationBrasser());
        operations.add(new OperationEmballer());
    }

}
