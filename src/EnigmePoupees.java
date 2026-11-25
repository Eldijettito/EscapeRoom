package src;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Représente l'énigme des poupées, 1ère énigme du niveau Chambre rose.
 * Le joueur doit placer les poupées dans le bon ordre pour résoudre l'énigme
 * 
 * @author Margaux Riffard
 */
public class EnigmePoupees extends Enigme {

    /**
     * Construit l'énigme des poupées et lui associe le chronomètre du jeu.
     * @param chrono le chronomètre du jeu
     */
    public EnigmePoupees(Chronometre chrono){
        super("Les poupées", chrono);
    }

    /**    
     * Lance le déroulement de l'énigme des poupées.
     * Le joueur doit placer les poupées dans le bon ordre pour résoudre l'énigme.
     * Vérifie le temps restant après chaque réponse.
     * 
     * @see src.Enigme#jouer()
     */
    @Override 
    public void jouer() {

        ArrayList<String> poupees = new ArrayList<>();
        poupees.add("Alice");
        poupees.add("Bella");
        poupees.add("Clara");
        poupees.add("Daisy");

        System.out.println("\nQuatre poupées sont posées sur une étagère.");
        System.out.println("Les poupées présentes sont :");

        for (String poupee : poupees) {
            System.out.println("- " + poupee);
        }

        System.out.println("\nUne note indique :");
        System.out.println("Alice se trouve avant Clara.");
        System.out.println("Bella est juste après Alice.");
        System.out.println("Daisy est la dernière.");
        System.out.println("Clara n'est pas la première.");

        System.out.println("\nDans quel ordre faut-il placer les poupées ?");
        
        Affichage.separation();
        
        System.out.println("1. Alice - Bella - Clara - Daisy");
        System.out.println("2. Clara - Alice - Bella - Daisy");
        System.out.println("3. Bella - Clara - Alice - Daisy");

        Affichage.separation();

        Scanner scanner = new Scanner(System.in);
        int choix = 0;

        while (choix != 1 && !chrono.estTermine()){
            System.out.print("Votre réponse : ");
            if (scanner.hasNextInt()) {

                choix = scanner.nextInt();
            } else {
                scanner.next();
                choix = 0;
                System.out.println("Réponse invalide ! Entrez un chiffre.");
                continue;
}
        if (chrono.estTermine()){
                return;
            }
            if (choix ==1){

                Affichage.reussite("Les poupées tournent lentement leurs têtes...");
                System.out.println("Un déclic se fait entendre, chercher la prochaine énigme.");
                System.out.println("Vous avez résolu la première énigme !");
            } else {
                Affichage.echec("Les poupées se mettent à rire...");
                chrono.ajouterMalus(10);

                System.out.println("Pénalité : -10 secondes");
                System.out.println("Temps restant : " + chrono.tempsRestant() + " secondes");

                Affichage.separation();
            }
        }
    }
}