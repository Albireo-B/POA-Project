package builder;

import main.Bonbon;
import main.Ingredient;

import java.util.AbstractMap;
import java.util.List;

public class ReglisseBuilder extends BonbonBuilder{

    @Override
    public BonbonBuilder Peser() {
        System.out.println("Cette préparation pèse 10g");
        return this;
    }

}
