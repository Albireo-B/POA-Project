package RoyaumeDesBonbons.operation;

import RoyaumeDesBonbons.bonbon.Ingredient;

import java.util.ArrayList;

public final class OperationMelanger extends OperationComposee {


    public OperationMelanger(ArrayList<Ingredient> listeIngredients) {
        super(listeIngredients);
        operation = "Mélanger " + listeIngredients.get(0).GetNom();
        for (int i = 1; i < listeIngredients.size(); i++) {
            operation += " et " + listeIngredients.get(i).GetNom();
        }
        operation += " ensembles.";
    }

}
