package builder;

import error.NoIngredientException;
import main.Bonbon;
import main.Ingredient;
import main.PoolIngredient;
import operation.Operation;
import recette.Recette;
import recette.RecetteJujube;
import recette.RecetteParDefaut;
import recette.RecetteReglisse;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class BonbonBuilderGuillaume {

    protected Bonbon bonbonABuild = null;
    protected String nomBonBon = null;
    protected Recette recetteBonbon = null;

    public BonbonBuilderGuillaume(String nomBonbon){
        this.nomBonBon = nomBonbon;
        System.out.println(RecetteJujube.class.getName());
        try {
            Class bonbonRecetteClass = Class.forName("recette.Recette"+nomBonbon);
            recetteBonbon = (Recette) bonbonRecetteClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            //e.printStackTrace();
            //Recette parar défaut quand on ne trouve pas la recette du bonbon
            recetteBonbon = new RecetteParDefaut();
        }
    }

    public Bonbon Build(){

        bonbonABuild = new Bonbon(this.nomBonBon);

        recetteBonbon.operations.forEach(operation -> {
            operation.AppliquerOperation();
        });

        recetteBonbon.ingredients.forEach((ingredient,integer) -> {
            bonbonABuild.AjouterIngredient(ingredient);
        });

        AfficherJournal(this.nomBonBon,recetteBonbon);
        return bonbonABuild;
    }

    private void AfficherJournal(String nomBonBon, Recette recette) {
        System.out.println("Un bonbon " + nomBonBon + " est souhaité !");
        System.out.println(recette.toString());
    }

}
