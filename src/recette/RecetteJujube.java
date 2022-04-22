package recette;

import error.NoIngredientException;
import error.PoolIngredientException;
import main.PoolIngredient;
import operation.OperationBrasser;
import operation.OperationEmballer;
import operation.OperationPeser;


public class RecetteJujube extends Recette {

    public RecetteJujube() throws PoolIngredientException {
        super();
        //On choisit les ingrédients présents dans la recette
        PoolIngredient poolIngredient = PoolIngredient.getInstance();

        ingredients.put(
                poolIngredient.PrendreIngredient(
                        poolIngredient.GetIngredient("Sucre"), 10
                ).getKey(),
                10);

        ingredients.put(
                poolIngredient.PrendreIngredient(
                        poolIngredient.GetIngredient("Pomme"), 10
                ).getKey(),
                10);

        ingredients.put(
                poolIngredient.PrendreIngredient(
                        poolIngredient.GetIngredient("Gélatine"), 10
                ).getKey(),
                10);

        ingredients.put(
                poolIngredient.PrendreIngredient(
                        poolIngredient.GetIngredient("Colorant"), 10
                ).getKey(),
                10);

        //On fait la liste des opérations avec leurs ingrédients (si oui) et on les éxecutes
        operations.add(new OperationPeser(poolIngredient.GetIngredient("Sucre")));
        operations.add(new OperationBrasser());
        operations.add(new OperationEmballer());
    }

}
