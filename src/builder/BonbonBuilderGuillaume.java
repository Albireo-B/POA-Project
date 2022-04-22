package builder;

import error.PoolIngredientException;
import bonbon.Bonbon;
import recette.Recette;
import recette.RecetteJujube;
import recette.RecetteParDefaut;

public class BonbonBuilderGuillaume {

    protected Bonbon bonbonABuild = null;
    protected String nomBonBon = null;
    protected Recette recetteBonbon = null;

    public BonbonBuilderGuillaume(String nomBonbon) {
        this.nomBonBon = nomBonbon;
        System.out.println(RecetteJujube.class.getName());
        try {
            Class bonbonRecetteClass = Class.forName("recette.Recette" + nomBonbon);
            recetteBonbon = (Recette) bonbonRecetteClass.getDeclaredConstructor().newInstance();
            return;
        } catch (Exception e) {
            //e.printStackTrace();
            //Recette parar défaut quand on ne trouve pas la recette du bonbon
            System.out.println(e);
            try {
                recetteBonbon = new RecetteParDefaut();
            } catch (PoolIngredientException exception2) {
                exception2.printStackTrace();
            }
        }
    }

    public Bonbon Build() {
        if (recetteBonbon == null) {
            System.out.print("Recette introuvable !");
            return null;
        }

        bonbonABuild = new Bonbon(this.nomBonBon);

        recetteBonbon.operations.forEach(operation -> {
            operation.AppliquerOperation();
        });

        recetteBonbon.ingredients.forEach((ingredient, integer) -> {
            bonbonABuild.AjouterIngredient(ingredient);
        });

        AfficherJournal(this.nomBonBon, recetteBonbon);
        return bonbonABuild;
    }

    private void AfficherJournal(String nomBonBon, Recette recette) {
        System.out.println("Un bonbon " + nomBonBon + " est souhaité !");
        System.out.println(recette.toString());
    }

}
