package main;

import builder.BonbonBuilder;
import builder.BonbonBuilderGuillaume;
import builder.JujubeBuilder;
import builder.ReglisseBuilder;

public class RoiDesBonbons {

    private static RoiDesBonbons single_instance = null;

    public static RoiDesBonbons getInstance()
    {
        if (single_instance == null)
            single_instance = new RoiDesBonbons();

        return single_instance;
    }

    public Bonbon SouhaitBonbon(String nomBonbon){
        if(PoolIngredient.getInstance().IsEmpty(10)){
            System.out.println("Il n'y a plus assez d'ingrédients !");
            return null;
        }

        BonbonBuilderGuillaume builder = new BonbonBuilderGuillaume(nomBonbon);
        Bonbon bonbon = builder.Build();
        return bonbon;
    }
}
