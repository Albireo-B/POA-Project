package RoyaumeDesBonbons.personnages;

import RoyaumeDesBonbons.bonbon.PoolIngredient;
import RoyaumeDesBonbons.bonbon.Bonbon;
import RoyaumeDesBonbons.error.NoIngredientException;
import RoyaumeDesBonbons.recette.Recette;

final class RoiDesBonbons {

    private static RoiDesBonbons single_instance = null;

    static RoiDesBonbons getInstance() {
        if (single_instance == null)
            single_instance = new RoiDesBonbons();

        return single_instance;
    }

    Bonbon SouhaitBonbon(String nomBonbon) {
        if (PoolIngredient.getInstance().IsEmpty(10)) {
            System.out.println("Il n'y a plus assez d'ingrédients !");
            return null;
        }

        BonbonBuilder builder = new BonbonBuilder(nomBonbon);
        Bonbon bonbon = null;
        try {
            bonbon = builder.Build();
        } catch (NoIngredientException e) {
            e.printStackTrace();
        }
        return bonbon;
    }
}
