import java.util.AbstractMap;
import java.util.List;

public class PoolIngredient {

    private static PoolIngredient instance = null;
    private List<AbstractMap<Ingredient,Integer>> ingredients;

    private PoolIngredient(){

    }

    public static PoolIngredient getInstance()
    {
        if (instance == null)
            instance = new PoolIngredient();

        return instance;
    }

    public boolean IngredientDisponible(Ingredient ingredient){
        return true;
    }

    public void PrendreIngredient(Ingredient ingredient, Integer quantite){

    }
}
