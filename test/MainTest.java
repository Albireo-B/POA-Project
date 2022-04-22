import bonbon.Bonbon;
import personnages.RoiDesBonbons;

public class MainTest {

    public static void main(String[] args){

        RoiDesBonbons.getInstance().SouhaitBonbon("Jujube");
        RoiDesBonbons.getInstance().SouhaitBonbon("Reglisse");
        RoiDesBonbons.getInstance().SouhaitBonbon("glbskf");

        for(int i = 0; i<100; i++){
            System.out.println("\n====UN BONBON EST DEMANDE====");
            Bonbon result = RoiDesBonbons.getInstance().SouhaitBonbon("glbskf");
            if(result==null){ break; }
        }

    }

}
