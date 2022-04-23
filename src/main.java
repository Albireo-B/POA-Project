import RoyaumeDesBonbons.personnages.Enfant;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Enfant enfant1 = new Enfant(new ArrayList<>());

        ArrayList<String> allergies = new ArrayList<String>();
        allergies.add("Anis");
        Enfant enfant2 = new Enfant(allergies);

        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);
        Enfant enfantSelectionne = enfant1;
        String demande;
        while (true){
            System.out.println("============================================================");
            System.out.println("= 1 : Sélectionner enfant sans allergie                    =");
            System.out.println("= 2 : Sélectionner enfant avec une allergie à l'Anis       =");
            System.out.println("= {NomBonbon} : Demande de bonbon via l'enfant sélectionné =");
            System.out.println("= q : Quitter                                              =");
            System.out.println("============================================================");
            demande = in.nextLine();
            if (demande.equals("q")){
                System.out.println("Arrêt en cours...");
                System.exit(0);
            }
            else if(demande.equals("1")){
                System.out.println("Enfant sans allergie sélectionné");
                enfantSelectionne = enfant1;
            }
            else if(demande.equals("2")){
                System.out.println("Enfant avec allergie à l'Anis sélectionné");
                enfantSelectionne = enfant2;
            }
            else{
                enfantSelectionne.souhaiterPourUnBonBon(demande);
            }
        }
    }
}
