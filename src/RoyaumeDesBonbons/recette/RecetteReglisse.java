package RoyaumeDesBonbons.recette;

import RoyaumeDesBonbons.error.NoIngredientException;
import RoyaumeDesBonbons.error.PoolIngredientException;
import RoyaumeDesBonbons.bonbon.PoolIngredient;
import RoyaumeDesBonbons.operation.OperationBrasser;
import RoyaumeDesBonbons.operation.OperationEmballer;
import RoyaumeDesBonbons.operation.OperationPeser;

public final class RecetteReglisse extends Recette {

    public RecetteReglisse() {
        super();
        //On choisit les ingrédients présents dans la recette
        PoolIngredient poolIngredient = PoolIngredient.getInstance();

        ingredients.put(poolIngredient.GetIngredient("Sucre"), 10);
        ingredients.put(poolIngredient.GetIngredient("Anis"), 10);
        ingredients.put(poolIngredient.GetIngredient("Gélatine"), 10);

        //On fait la liste des opérations avec leurs ingrédients (si oui) et on les éxecutes
        operations.add(new OperationPeser(poolIngredient.GetIngredient("Sucre")));
        operations.add(new OperationBrasser());
        operations.add(new OperationEmballer());
    }
}
