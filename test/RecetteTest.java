import main.Bonbon;
import recette.Recette;
import recette.RecetteJujube;
import recette.RecetteReglisse;

public class RecetteTest {

    public void RecetteReglisse(){
        Recette recette = new RecetteReglisse();
        Bonbon bonbon = recette.PreparerBonbon();
        System.out.println(bonbon.toString());
    }

    public void RecetteJujube(){
        Recette recette = new RecetteJujube();
        Bonbon bonbon = recette.PreparerBonbon();
        System.out.println(bonbon.toString());
    }
}
