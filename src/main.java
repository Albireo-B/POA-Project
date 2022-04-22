import personnages.Enfant;

import java.util.List;

public class main {
    public static void main(String[] args) {
        Enfant enfant1 = new Enfant(List.of("Sucre"));
        enfant1.souhaiterPourUnBonBon("Jujube");
    }
}
