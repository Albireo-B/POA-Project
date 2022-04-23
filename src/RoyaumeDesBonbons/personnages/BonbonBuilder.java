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
            System.out.println("Recette introuvable !");
            recetteBonbon = new RecetteParDefaut(10);
        }
    }

    Bonbon Build() throws NoIngredientException {

        System.out.println("Un bonbon " + this.nomBonbon + " est souhaité !");

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

        recetteBonbon.getIngredients().forEach((ingredient, integer) -> {
            bonbonABuild.AjouterIngredient(ingredient);
            System.out.println("Ajouter " + ingredient.GetNom() + " en quantité : " + integer);
        });

        recetteBonbon.getOperations().forEach(Operation::AppliquerOperation);


        AfficherRecette(recetteBonbon);
        return bonbonABuild;
    }

    private void AfficherRecette(Recette recette) {
        System.out.println(recette.toString());
    }

    private void setNomBonbon(String nomBonbon) {
        this.nomBonbon = nomBonbon;
    }

}
