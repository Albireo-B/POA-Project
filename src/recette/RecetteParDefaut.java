package recette;

import builder.BonbonDefautBuilder;
import main.Bonbon;
import main.Ingredient;

import java.util.AbstractMap;

public class RecetteParDefaut  extends Recette {

    public RecetteParDefaut(){
        builder = new BonbonDefautBuilder();
    }

    @Override
    public Bonbon PreparerBonbon(){
        //A IMPLEMENTER
        return builder.Build();
    }
}
