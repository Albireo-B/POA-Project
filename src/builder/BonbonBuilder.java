package builder;

import error.NoIngredientException;
import main.Bonbon;
import main.Ingredient;
import main.PoolIngredient;

import java.util.AbstractMap;
import java.util.List;

public abstract class BonbonBuilder {

    protected Bonbon bonbonABuild = null;
    protected String nomBonBon = null;

    public BonbonBuilder Melanger(){
        System.out.println("Mélange la pâte");
        return this;
    }

    public BonbonBuilder AjouterIngredient(AbstractMap.SimpleEntry<Ingredient,Integer> ingredient){

        bonbonABuild = new Bonbon(this.nomBonBon);

        try{
            PoolIngredient.getInstance().PrendreIngredient(ingredient.getKey(), ingredient.getValue());
        }
        catch(NoIngredientException exception){
            System.out.println(exception);
            return this;
        }

        bonbonABuild.AjouterIngredient(ingredient.getKey());
        return this;
    }

    public BonbonBuilder Peser(){
        return this;
    }

    public Bonbon Build(){
        return bonbonABuild;
    }

    //PLUS DE METHODES EST NECESSAIRE JE PENSE

}
