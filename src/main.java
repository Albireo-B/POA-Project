import RoyaumeDesBonbons.personnages.Enfant;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Enfant enfant1 = new Enfant(new ArrayList<>());
        enfant1.souhaiterPourUnBonBon("Jujube");
        enfant1.souhaiterPourUnBonBon("Reglisse");
        enfant1.souhaiterPourUnBonBon("Carambar");

        ArrayList<String> allergies = new ArrayList<String>();
        allergies.add("Anis");
        Enfant enfant2 = new Enfant(allergies);
        enfant2.souhaiterPourUnBonBon("Reglisse");

        for(int i=0; i<30; i++){
            enfant1.souhaiterPourUnBonBon("Reglisse");
        }

        for(int i=0; i<75; i++){
            enfant1.souhaiterPourUnBonBon("Carambar");
        }
    }
}
