package builder;

import main.Bonbon;

public class ReglisseBuilder extends BonbonBuilder{


    public ReglisseBuilder(){
        bonbonABuild = new Bonbon("Reglisse");
    }

    @Override
    public BonbonBuilder Peser() {
        System.out.println("Cette préparation pèse 10g");
        return this;
    }

    @Override
    public BonbonBuilder Melanger() {
        System.out.println("Mélange la pâte avec force pendant 10 minutes");
        return this;
    }
}
