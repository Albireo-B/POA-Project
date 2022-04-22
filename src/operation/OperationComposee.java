package operation;

import bonbon.Ingredient;

import java.util.ArrayList;

public abstract class OperationComposee extends Operation {

    protected ArrayList<Ingredient> listeIngredientsOperation;

    public OperationComposee(Ingredient ingredient) {
        listeIngredientsOperation = new ArrayList<>();
        this.listeIngredientsOperation.add(ingredient);
    }

    public OperationComposee(ArrayList<Ingredient> listeIngredientsOperation) {
        this.listeIngredientsOperation = listeIngredientsOperation;
    }
}
