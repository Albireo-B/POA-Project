package RoyaumeDesBonbons.recette;

import RoyaumeDesBonbons.bonbon.Ingredient;
import RoyaumeDesBonbons.bonbon.PoolIngredient;
import RoyaumeDesBonbons.operation.OperationBrasser;
import RoyaumeDesBonbons.operation.OperationEmballer;
import RoyaumeDesBonbons.operation.OperationMelanger;
import RoyaumeDesBonbons.operation.OperationPeser;

import java.util.ArrayList;

public final class RecetteDragibus extends Recette{

    public RecetteDragibus(){
        super();
        //On choisit les ingrédients présents dans la recette
        PoolIngredient poolIngredient = PoolIngredient.getInstance();


        ingredients.put(poolIngredient.GetIngredient("Sucre"), 30);
        ingredients.put(poolIngredient.GetIngredient("Gélatine"), 20);
        ingredients.put(poolIngredient.GetIngredient("Colorant"), 5);


        operations.add(new OperationPeser(poolIngredient.GetIngredient("Sucre")));
        ArrayList<Ingredient> ingredientsAMelanger = new ArrayList<>();
        ingredientsAMelanger.add(poolIngredient.GetIngredient("Sucre"));
        ingredientsAMelanger.add(poolIngredient.GetIngredient("Gélatine"));
        ingredientsAMelanger.add(poolIngredient.GetIngredient("Colorant"));
        operations.add(new OperationMelanger(ingredientsAMelanger));
        operations.add(new OperationBrasser());
        operations.add(new OperationEmballer());
    }

}
