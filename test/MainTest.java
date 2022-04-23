import RoyaumeDesBonbons.bonbon.Bonbon;
import RoyaumeDesBonbons.bonbon.PoolIngredient;
import RoyaumeDesBonbons.personnages.Enfant;

import java.util.ArrayList;
import java.util.Scanner;

public class MainTest {

    public static void main(String[] args){

        // On doit maintenant passer par l<enfant pour faire les souhaits
        /*RoiDesBonbons.getInstance().SouhaitBonbon("Jujube");
        RoiDesBonbons.getInstance().SouhaitBonbon("Reglisse");
        RoiDesBonbons.getInstance().SouhaitBonbon("glbskf");

        for(int i = 0; i<100; i++){
            System.out.println("\n====UN BONBON EST DEMANDE====");
            Bonbon result = RoiDesBonbons.getInstance().SouhaitBonbon("glbskf");
            if(result==null){ break; }
        }*/


        Enfant enfant1 = new Enfant(new ArrayList<>());//(List.of("Sucre"));

        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);
        String bonbonSouhaité;
        while (true){

            bonbonSouhaité = in.nextLine();
            if (bonbonSouhaité == "")
                System.exit(0);
            enfant1.souhaiterPourUnBonBon(bonbonSouhaité);
        }
        /*
        for(int i = 0; i<100; i++){
            System.out.println("\n====UN BONBON EST DEMANDE====");
            enfant1.souhaiterPourUnBonBon("Jujube");
        }
        */
        /*enfant1.souhaiterPourUnBonBon("AAAAAAAAAa");
        enfant1.souhaiterPourUnBonBon("Jujube");
        enfant1.souhaiterPourUnBonBon("Arlequin");
        enfant1.souhaiterPourUnBonBon("Reglisse");
        enfant1.souhaiterPourUnBonBon("Dragibus");*/
    }

}
