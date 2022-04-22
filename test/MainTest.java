import main.RoiDesBonbons;

public class MainTest {

    public static void main(String[] args){

        RoiDesBonbons.getInstance().SouhaitBonbon("Jujube");
        RoiDesBonbons.getInstance().SouhaitBonbon("Reglisse");
        RoiDesBonbons.getInstance().SouhaitBonbon("glbskf");

        for(int i = 0; i<100; i++){
            RoiDesBonbons.getInstance().SouhaitBonbon("glbskf");
        }

    }

}
