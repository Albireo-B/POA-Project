import builder.BonbonBuilder;
import builder.JujubeBuilder;
import builder.ReglisseBuilder;
import main.Bonbon;
import main.Ingredient;

import java.util.AbstractMap;

public class BonbonBuilderTest {

    public BonbonBuilderTest(){ }

    public void TestJubule(){
        JujubeBuilder builder = new JujubeBuilder();
        builder.AjouterIngredient(new AbstractMap.SimpleEntry<Ingredient, Integer>(new Ingredient("Sucre"), 20));
        Bonbon item = builder.Build();
        System.out.println(item);
    }

    public void TestReglisse(){
        ReglisseBuilder builder = new ReglisseBuilder();
        builder.AjouterIngredient(new AbstractMap.SimpleEntry<Ingredient, Integer>(new Ingredient("Gélatine"), 10));
        Bonbon item = builder.Build();
        System.out.println(item);
    }

}
