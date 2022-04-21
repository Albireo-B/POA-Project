package recette;

import builder.ReglisseBuilder;
import main.Bonbon;
import main.Ingredient;

import java.util.AbstractMap;

public class RecetteReglisse  extends Recette {

    public RecetteReglisse(){
        builder = new ReglisseBuilder();
    }

    @Override
    public Bonbon PreparerBonbon(){
        builder.AjouterIngredient(new AbstractMap.SimpleEntry<Ingredient, Integer>(
                new Ingredient("Sucre"), 5
        ));
        builder.AjouterIngredient(new AbstractMap.SimpleEntry<Ingredient, Integer>(
                new Ingredient("Anis"), 10
        ));
        builder.AjouterIngredient(new AbstractMap.SimpleEntry<Ingredient, Integer>(
                new Ingredient("Colorant"), 6
        ));
        builder.Melanger();
        builder.Peser();
        return builder.Build();
    }
}
