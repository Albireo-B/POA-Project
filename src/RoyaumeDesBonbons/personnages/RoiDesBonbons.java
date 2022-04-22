package RoyaumeDesBonbons.personnages;

import RoyaumeDesBonbons.bonbon.PoolIngredient;
import RoyaumeDesBonbons.bonbon.Bonbon;
import RoyaumeDesBonbons.error.NoIngredientException;
import RoyaumeDesBonbons.error.PoolEmptyException;
import RoyaumeDesBonbons.error.PoolIngredientException;
import RoyaumeDesBonbons.recette.Recette;

final class RoiDesBonbons {

    private static RoiDesBonbons single_instance = null;

    static RoiDesBonbons getInstance() {
        if (single_instance == null)
            single_instance = new RoiDesBonbons();

        return single_instance;
    }

    Bonbon SouhaitBonbon(String nomBonbon) throws PoolIngredientException {
        System.out.println("\n====SOUHAIT BONBON====");
        if (PoolIngredient.getInstance().IsEmpty(10)) {
            throw new PoolEmptyException("Il n'y a plus assez d'ingrédients !");
        }

        BonbonBuilder builder = new BonbonBuilder(nomBonbon);
        Bonbon bonbon = null;
        bonbon = builder.Build();
        return bonbon;
    }
}
