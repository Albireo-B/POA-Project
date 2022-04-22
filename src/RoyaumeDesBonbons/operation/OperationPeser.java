package RoyaumeDesBonbons.operation;

import RoyaumeDesBonbons.bonbon.Ingredient;

public final class OperationPeser extends OperationComposee {

    public OperationPeser(Ingredient ingredient) {
        super(ingredient);
        operation = "Peser " + ingredient;
    }
}
