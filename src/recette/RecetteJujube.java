package recette;

import builder.JujubeBuilder;
import main.Bonbon;
import main.Ingredient;

import java.util.AbstractMap;

public class RecetteJujube extends Recette {

    public RecetteJujube(){
        builder = new JujubeBuilder();
    }

    @Override
    public Bonbon PreparerBonbon(){
        builder.AjouterIngredient(new AbstractMap.SimpleEntry<Ingredient, Integer>(
                new Ingredient("Sucre"), 5
        ));
        builder.AjouterIngredient(new AbstractMap.SimpleEntry<Ingredient, Integer>(
                new Ingredient("Banane"), 10
        ));
        builder.AjouterIngredient(new AbstractMap.SimpleEntry<Ingredient, Integer>(
                new Ingredient("Colorant"), 6
        ));
        builder.AjouterIngredient(new AbstractMap.SimpleEntry<Ingredient, Integer>(
                new Ingredient("Sucre acidulé"), 10
        ));
        builder.Melanger();
        builder.Peser();
        return builder.Build();
    }
}
