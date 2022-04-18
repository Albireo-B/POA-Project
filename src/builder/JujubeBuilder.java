package builder;

import main.Bonbon;
import main.Ingredient;

import java.util.AbstractMap;
import java.util.List;

public class JujubeBuilder implements BonbonBuilder{

    @Override
    public BonbonBuilder Melanger() {
        return null;
    }

    @Override
    public BonbonBuilder AjouterIngredient(List<AbstractMap<Ingredient, Integer>> ingredients) {
        return null;
    }

    @Override
    public BonbonBuilder Peser() {
        return null;
    }

    @Override
    public Bonbon Build() {
        return null;
    }

    @Override
    public Bonbon GetBonbon() {
        return null;
    }
}
