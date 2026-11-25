package src;
import java.util.Scanner;


/**
 * Représente la première énigme du cinéma.
 * Le joueur doit retrouver un code à partir des indices inscrits sur un ticket.
 *
 * @author Fanny Bouffard
 */
public class EnigmeTicket extends Enigme {


    public EnigmeTicket(Chronometre chrono) {
        super("Le ticket mystérieux", chrono);
    }


    @Override
    public void jouer() {


        Scanner scanner = new Scanner(System.in);
        boolean resolu = false;


        System.out.println("Vous trouvez un ticket de cinéma sous votre siège.");
        System.out.println("Le ticket contient trois indices :");
        System.out.println("Premier chiffre : le double de 2.");
        System.out.println("Deuxième chiffre : le nombre de lettres du mot FILM.");
        System.out.println("Troisième chiffre : 9 - 6.");


        while (!resolu && !chrono.estTermine()) {


            System.out.print("\nEntrez le code à trois chiffres : ");
            String reponse = scanner.nextLine();


            if (reponse.equals("443")) {


                Affichage.reussite("La cabine de projection s'ouvre !");
                System.out.println("Vous avez résolu la première énigme.");
                resolu = true;


            } else {


                Affichage.echec("Le ticket se déchire entre vos doigts...");
                chrono.ajouterMalus(10);


                System.out.println("Vous perdez 10 secondes.");
                System.out.println("Temps restant : " + chrono.tempsRestant() + " secondes.");
                Affichage.separation();
            }
        }
    }
}
