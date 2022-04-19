package builder;

import error.NoIngredientException;
import main.Bonbon;
import main.Ingredient;
import main.PoolIngredient;

import java.util.AbstractMap;
import java.util.List;

public abstract class BonbonBuilder {

    protected Bonbon resultat = null;

    public BonbonBuilder Melanger(){
        System.out.println("Mélange la pâte");
        return this;
    }

    public BonbonBuilder AjouterIngredient(AbstractMap.SimpleEntry<Ingredient,Integer> ingredient){
        if(resultat==null){
            resultat = new Bonbon("Jujube");
        }

        try{
            PoolIngredient.getInstance().PrendreIngredient(ingredient.getKey(), ingredient.getValue());
        }
        catch(NoIngredientException exception){
            System.out.println(exception);
            return this;
        }

        resultat.AjouterIngredient(ingredient.getKey());
        return this;
    }

    public BonbonBuilder Peser(){
        return this;
    }

    public Bonbon Build(){
        return resultat;
    }

    //PLUS DE METHODES EST NECESSAIRE JE PENSE

}
