package operation;

import main.Ingredient;

public class OperationPeser extends OperationComposee{

    public OperationPeser(Ingredient ingredient) {
        super(ingredient);
        operation = "Peser " + ingredient;
    }
}
