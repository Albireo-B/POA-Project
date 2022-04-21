package builder;

import error.NoIngredientException;
import main.Bonbon;
import main.Ingredient;
import main.PoolIngredient;
import recette.RecetteJujube;

import java.util.AbstractMap;
import java.util.List;

public class JujubeBuilder extends BonbonBuilder{

    public JujubeBuilder(){
        nomBonBon = "Jujube";
        recetteBonbon =  new RecetteJujube();
    }

    @Override
    public Bonbon Build() {

        bonbonABuild = new Bonbon(this.nomBonBon);

        recetteBonbon.operations.forEach(operation -> {
                operation.AppliquerOperation();
        });

        recetteBonbon.ingredients.forEach((ingredient,integer) -> {
            bonbonABuild.AjouterIngredient(ingredient);
        });

        return super.Build();
    }

    @Override
    public BonbonBuilder Peser() {
        System.out.println("Cette préparation pèse 20g");
        return this;
    }

}
