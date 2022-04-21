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

        BonbonBuilderGuillaume builder = new BonbonBuilderGuillaume(nomBonbon);
        Bonbon bonbon = builder.Build();
        return bonbon;
    }
}
