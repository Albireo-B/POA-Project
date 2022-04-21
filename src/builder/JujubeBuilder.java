package builder;

import main.Bonbon;

public class JujubeBuilder extends BonbonBuilder{

    public JujubeBuilder(){

        bonbonABuild = new Bonbon("Jujube");
    }

    @Override
    public BonbonBuilder Peser() {
        System.out.println("Cette préparation pèse 20g");
        return this;
    }

}
