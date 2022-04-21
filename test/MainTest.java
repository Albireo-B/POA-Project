import main.RoiDesBonbons;

public class MainTest {

    public static void main(String[] args){

        RoiDesBonbons.getInstance().SouhaitBonbon("Jujube");

        BonbonBuilderTest bonbonBuilderTest = new BonbonBuilderTest();
        bonbonBuilderTest.TestReglisse();
    }

}
