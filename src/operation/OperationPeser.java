package operation;

import bonbon.Ingredient;

public class OperationPeser extends OperationComposee {

    public OperationPeser(Ingredient ingredient) {
        super(ingredient);
        operation = "Peser " + ingredient;
    }
}
