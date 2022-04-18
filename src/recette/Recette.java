package recette;

import builder.BonbonBuilder;
import main.Ingredient;

import java.util.AbstractMap;
import java.util.List;

public abstract class Recette {

    public BonbonBuilder builder;
    public AbstractMap<Ingredient,Integer> ingredients;

    public void PreparerBonbon(){

    }
}
