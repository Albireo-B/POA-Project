package builder;

import main.Bonbon;
import main.Ingredient;

import java.util.AbstractMap;
import java.util.List;

public interface BonbonBuilder {

    Bonbon resultat = null;

    BonbonBuilder Melanger();
    BonbonBuilder AjouterIngredient(List<AbstractMap<Ingredient,Integer>> ingredients);
    BonbonBuilder Peser();
    Bonbon Build();
    Bonbon GetBonbon();



}
