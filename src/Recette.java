import java.util.AbstractMap;
import java.util.List;

public abstract class Recette {

    public BonbonBuilder builder;
    public List<AbstractMap<Ingredient,Integer>> ingredients;

    public void PreparerBonbon(){

    }
}
