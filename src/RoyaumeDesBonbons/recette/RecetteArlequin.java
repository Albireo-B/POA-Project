package RoyaumeDesBonbons.recette;

import RoyaumeDesBonbons.bonbon.Ingredient;
import RoyaumeDesBonbons.bonbon.PoolIngredient;
import RoyaumeDesBonbons.operation.OperationBrasser;
import RoyaumeDesBonbons.operation.OperationEmballer;
import RoyaumeDesBonbons.operation.OperationMelanger;
import RoyaumeDesBonbons.operation.OperationPeser;

import java.util.ArrayList;

public class RecetteArlequin extends Recette {


    public RecetteArlequin() {
        super();
        //On choisit les ingrédients présents dans la recette
        PoolIngredient poolIngredient = PoolIngredient.getInstance();


        ingredients.put(poolIngredient.GetIngredient("Sucre acidulé"), 20);
        ingredients.put(poolIngredient.GetIngredient("Pomme"), 10);
        ingredients.put(poolIngredient.GetIngredient("Poire"), 10);
        ingredients.put(poolIngredient.GetIngredient("Colorant"), 5);


        operations.add(new OperationPeser(poolIngredient.GetIngredient("Sucre acidulé")));
        ArrayList<Ingredient> ingredientsAMelanger = new ArrayList<>();
        ingredientsAMelanger.add(poolIngredient.GetIngredient("Sucre acidulé"));
        ingredientsAMelanger.add(poolIngredient.GetIngredient("Pomme"));
        ingredientsAMelanger.add(poolIngredient.GetIngredient("Poire"));
        operations.add(new OperationMelanger(ingredientsAMelanger));
        operations.add(new OperationBrasser());
        operations.add(new OperationEmballer());
    }
}
