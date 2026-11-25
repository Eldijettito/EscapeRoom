package src;

import java.util.Random;
import java.util.Scanner;

public class JustePrix extends Enigme {

    private static final int PRIX_MIN = 1000;
    private static final int PRIX_MAX = 1000000;
    private static final int NB_ESSAIS = 5;

    private int prixMystere;

    // Constructeur : Vincent Lagaffe choisit un prix au hasard
    public JustePrix(Chronometre chrono) {
        super("JustePrix", chrono);
        Random random = new Random();
        this.prixMystere = PRIX_MIN + random.nextInt(PRIX_MAX - PRIX_MIN + 1);
    }

    @Override
    public void jouer() {
        Scanner scanner = new Scanner(System.in);
        justePrix(scanner);
    }

    // Jeu du juste prix : renvoie true si le joueur gagne, false s'il perd
    public boolean justePrix(Scanner scanner) {

        System.out.println("\nJEU DU JUSTE PRIX");
        System.out.println("Vous êtes enfin libre, Vous décidez de profiter de la vie !");
        System.out.println("Bip Biiiiip");
        System.out.println("Une voiture apparaît sur votre droite");
        System.out.println("'Oui bonjour c'est Vincent Lagaffe !'");

        System.out.println("Il vous invite à rentrer dans sa voiture afin de vous déposer au centre-ville");
		System.out.println("Vous acceptez l'invitation, épuisé du moment que vous venez de passer");
		System.out.println("Vous rentrez dans la voiture et fermez la portière");
		System.out.println("Click...");
		System.out.println("Le verrou de la porte est activé... vous êtes coincé avec Vincent Lagaffe");
		System.out.println("Ce dernier vous propose de jouer à un jeu,");
		System.out.println("Il sort une liasse de billets et vous demande de choisir un nombre entre 1 000 et 1 000 000 ");
        System.out.println("\"J'ai choisi un prix entre " + PRIX_MIN + " et " + PRIX_MAX + ".\"");
        System.out.println("\"Trouvez-le en " + NB_ESSAIS + " essais, ou je vous plante !\"");

        int essaisRestants = NB_ESSAIS;

        while (essaisRestants > 0) {

            System.out.print("\nVotre prix (" + essaisRestants + " essai(s) restant(s)) : ");
            String saisie = scanner.nextLine().trim();

            int proposition;
            try {
                proposition = Integer.parseInt(saisie);
            } catch (NumberFormatException e) {
                System.out.println("Vincent Lagaffe : \"Un nombre, s'il vous plaît !\"");
                continue;
            }

            if (proposition < PRIX_MIN || proposition > PRIX_MAX) {
                System.out.println("Vincent Lagaffe : \"Entre " + PRIX_MIN + " et " + PRIX_MAX + " !\"");
                continue;
            }

            essaisRestants--;

            if (proposition == prixMystere) {
                System.out.println("Vincent Lagaffe : \"C'est le juste prix !\"");
                System.out.println("Il baisse son couteau en grimaçant et s'efface dans l'obscurité.");
                return true;
            } else if (proposition < prixMystere) {
                System.out.println("Vincent Lagaffe : \"C'est plus !\"");
            } else {
                System.out.println("Vincent Lagaffe : \"C'est moins !\"");
            }
        }

        System.out.println("\nVincent Lagaffe : \"Perdu ! Le juste prix était " + prixMystere + ".\"");
        System.out.println("Il s'avance vers vous, un couteau à la main...");
        System.out.println("Vous vous faites planter par Vincent Lagaffe.");
        System.out.println("\nGAME OVER !");
        return false;
    }
}