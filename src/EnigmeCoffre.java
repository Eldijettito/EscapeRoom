package src;
import java.util.Scanner;

public class EnigmeCoffre extends Enigme {

    public EnigmeCoffre(Chronometre chrono) {
        super("Le Coffre de la Salle Principale", chrono);
    }

    @Override
    public void jouer() {
        Scanner scanner = new Scanner(System.in);
        boolean codeTrouve = false;

        System.out.println("Vous êtes de retour devant le lourd coffre métallique du début.");
        System.out.println("Vous avez rassemblé tous les indices.");

        while (!codeTrouve) {
            System.out.print("Entrez le code à 4 chiffres du coffre : ");
            String codeSaisi = scanner.nextLine().trim();

            if (codeSaisi.equals("7359")) {
                Affichage.reussite("CLIC ! Le coffre s'ouvre ! Vous récupérez la grande clé de la porte de sortie !");
                codeTrouve = true;
            } else {
                Affichage.echec("Bip rouge ! Le code est incorrect. Le coffre reste verrouillé.");
                // Optionnel : vous pouvez ajouter un malus de temps ici si vous le souhaitez
                // chrono.ajouterMalus(10); 
            }
        }
    }
}