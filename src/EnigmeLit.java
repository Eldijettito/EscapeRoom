package src;
import java.util.Scanner;

public class EnigmeLit extends Enigme {

    public EnigmeLit(Chronometre chrono) {
        super("Fouille de la Zone de Réveil", chrono);
    }

    @Override
    public void jouer() {
        Scanner scanner = new Scanner(System.in);
        boolean aTrouveIndice = false;

        while (!aTrouveIndice) {
            System.out.println("Vous retournez fouiller la zone du réveil, près du lourd coffre métallique.");
            System.out.println("1 - Fouiller le vieux lit de camp crasseux");
            System.out.println("2 - Examiner le squelette au sol");
            System.out.print("Que faites-vous ? (1 ou 2) : ");
            String choix = scanner.nextLine().trim();

            if (choix.equals("1")) {
                System.out.println("\n[LEURRE] Vous plongez vos mains dans les vieux matelas déchirés... Il n'y a rien d'autre que de la poussière et une odeur de rance. C'était une fausse piste !\n");
            } else if (choix.equals("2")) {
                System.out.println("\nVous vous accroupissez près du squelette au sol...");
                System.out.println("En inspectant de plus près la bague en argent terni à son doigt osseux, vous remarquez un chiffre gravé : [ 3 ] !");
                Affichage.reussite("Chiffre débloqué : [ 3 ] (2ème chiffre du coffre).");
                aTrouveIndice = true;
            } else {
                System.out.println("Choix invalide. Entrez 1 ou 2.\n");
            }
        }
    }
}