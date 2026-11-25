package src;
import java.util.Scanner;

public class EnigmeBibliotheque extends Enigme {

    public EnigmeBibliotheque(Chronometre chrono) {
        super("La Bibliothèque", chrono);
    }

    @Override
    public void jouer() {
        Scanner scanner = new Scanner(System.in);
        boolean reussite = false;

        System.out.println("Vous entrez dans une bibliothèque sombre remplie de vieux grimoires poussiéreux.");
        System.out.println("Sur la table, les tranches de livres affichent une opération en chiffres romains : 'VIII / II - I = ?'");

        while (!reussite) {
            System.out.print("Entrez votre réponse : ");
            String reponse = scanner.nextLine().trim();

            // On suppose que la bonne réponse est 3 (d'après le calcul VIII / II - I)
            if (reponse.equals("3")) {
                Affichage.reussite("Clic ! Un tiroir secret s'ouvre dans le bois de la bibliothèque !\n" +
                                   "À l'intérieur, vous découvrez le chiffre de l'indice : [ 9 ] et une petite clé rouillée.");
                reussite = true;
            } else {
                Affichage.echec("Ce n'est pas la bonne réponse. Le mécanisme reste verrouillé, réessayez.");
            }
        }
    }
}