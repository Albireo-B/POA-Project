package recette;

import error.NoIngredientException;
import main.PoolIngredient;
import operation.OperationBrasser;
import operation.OperationEmballer;
import operation.OperationPeser;


public class RecetteJujube extends Recette {

    public RecetteJujube(){
        super();
        //On choisit les ingrédients présents dans la recette
        PoolIngredient poolIngredient = PoolIngredient.getInstance();
        try{
            ingredients.put(poolIngredient.PrendreIngredient(poolIngredient.GetIngredient("Sucre"), 25).getKey(),25);

        }
        catch(NoIngredientException exception){
            System.out.println(exception);
        }
        //On fait la liste des opérations avec leurs ingrédients (si oui) et on les éxecutes
        operations.add(new OperationPeser(poolIngredient.GetIngredient("Sucre")));
        operations.add(new OperationBrasser());
        operations.add(new OperationEmballer());
    }

}
