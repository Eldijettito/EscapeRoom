package src;
import java.util.Scanner;

/**
 * Représente l'énigme du miroir, 2ème énigme du niveau Chambre rose.
 * Le joueur doit comprendre le message écrit à l'envers sur le miroir pour résoudre l'énigme
 * 
 * @author Margaux Riffard
 * EnigmeMiroir
 */
public class EnigmeMiroir extends Enigme{

    /**
     * Construit l'énigme du miroir et lui associe le chronomètre du jeu.
     * 
     * @param chrono le chronomètre du jeu
     */
    public EnigmeMiroir(Chronometre chrono) {
        super("Enigme du miroir", chrono);
    }

    /**   
     * Lance le déroulement de l'énigme du miroir.
     * Le joueur doit comprendre le message écrit à l'envers sur le miroir pour résoudre l'énigme.
     * Vérifie le temps restant après chaque réponse.   
     * 
     * @see src.Enigme#jouer()
     */
    @Override
    public void jouer() {

        System.out.println("Un bruit étrange retentit derrière vous...");
        System.out.println("Vous vous retournez vers la coiffeuse.");

        System.out.println("Une inscription apparaît sur le miroir :");
        System.out.println("\"ELBAT AL SUOS EDRAGER\"");

        System.out.println("\nQue signifie ce message ?");

        Affichage.separation();

        System.out.println("1. Regarde derrière le miroir");
        System.out.println("2. Regarde dans le placard");
        System.out.println("3. Regarde sous la table");

        Affichage.separation();

    Scanner scanner = new Scanner(System.in);

    int choix = 0;

    while (choix != 3 && !chrono.estTermine()) {

        System.out.print("\nVotre réponse : ");
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
    if (choix == 3) {

        Affichage.reussite("Vous regardez sous la table...");
        System.out.println("Vous découvrez une petite clé dorée !");
        System.out.println("Cette clé semble ouvrir une boîte sur la coiffeuse.");

    } else {
        Affichage.echec("Le miroir se fissure brusquement !");
        chrono.ajouterMalus(10);

        System.out.println("Pénalité : -10 secondes");
        System.out.println("Temps restant : " + chrono.tempsRestant() + " secondes");

        Affichage.separation();
    }
    } 
}
    
}
