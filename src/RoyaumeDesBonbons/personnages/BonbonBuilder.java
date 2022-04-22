package RoyaumeDesBonbons.personnages;

import RoyaumeDesBonbons.bonbon.Ingredient;
import RoyaumeDesBonbons.bonbon.PoolIngredient;
import RoyaumeDesBonbons.error.NoIngredientException;
import RoyaumeDesBonbons.recette.Recette;
import RoyaumeDesBonbons.recette.RecetteParDefaut;
import RoyaumeDesBonbons.bonbon.Bonbon;
import RoyaumeDesBonbons.operation.Operation;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

final class BonbonBuilder {

    private Bonbon bonbonABuild;
    private String nomBonbon;
    private Recette recetteBonbon;

    BonbonBuilder(String nomBonbon) {
        setNomBonbon(nomBonbon);
        try {
            Class bonbonRecetteClass = Class.forName("RoyaumeDesBonbons.recette.Recette" + nomBonbon);
            recetteBonbon = (Recette) bonbonRecetteClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            recetteBonbon = new RecetteParDefaut(10);
        }
    }

    Bonbon Build() throws NoIngredientException {
        if (recetteBonbon == null) {
            System.out.print("Recette introuvable !");
            return null;
        }

        bonbonABuild = new Bonbon(this.nomBonbon);

        // Verifier que tous les ingredients sont dispos
        for (Map.Entry<Ingredient, Integer> entry : recetteBonbon.getIngredients().entrySet()) {
            if (!PoolIngredient.getInstance().ingredientQuantiteDisponible(entry.getKey(), entry.getValue())) {
                throw new NoIngredientException("Impossible d'obtenir la quantite necessaire pour " + entry.getKey());
            }
        }

        // Maintenant que qu'on sait qu'on a tous les ingredients en stock, on les prends
        for (Map.Entry<Ingredient, Integer> entry : recetteBonbon.getIngredients().entrySet()) {
            PoolIngredient.getInstance().PrendreIngredient(entry.getKey(), entry.getValue());
        }

        recetteBonbon.getOperations().forEach(Operation::AppliquerOperation);

        recetteBonbon.getIngredients().forEach((ingredient, integer) -> {
            bonbonABuild.AjouterIngredient(ingredient);
        });

        AfficherJournal(this.nomBonbon, recetteBonbon);
        return bonbonABuild;
    }

    private void AfficherJournal(String nomBonBon, Recette recette) {
        System.out.println("Un bonbon " + nomBonBon + " est souhaité !");
        System.out.println(recette.toString());
    }

    private void setNomBonbon(String nomBonbon) {
        this.nomBonbon = nomBonbon;
    }

}
