package builder;

import error.NoIngredientException;
import main.Bonbon;
import main.Ingredient;
import main.PoolIngredient;

import java.util.AbstractMap;
import java.util.List;

public class JujubeBuilder extends BonbonBuilder{

    @Override
    public BonbonBuilder Peser() {
        System.out.println("Cette préparation pèse 20g");
        return this;
    }

}
