import RoyaumeDesBonbons.personnages.Enfant;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Enfant enfant1 = new Enfant(new ArrayList<>());//(List.of("Sucre"));
        enfant1.souhaiterPourUnBonBon("Jujube");
        enfant1.souhaiterPourUnBonBon("Reglisse");
        enfant1.souhaiterPourUnBonBon("Carambar");

        for(int i=0; i<30; i++){
            enfant1.souhaiterPourUnBonBon("Reglisse");
        }
    }
}
