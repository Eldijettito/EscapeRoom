package src;
import java.util.Scanner;


/**
 * Représente la deuxième énigme du cinéma.
 * Le joueur doit trouver le bon ordre des interrupteurs grâce à une inscription.
 *
 * @author Fanny Bouffard
 */
public class EnigmeProjecteur extends Enigme {


    private int batterie = 100;


    public EnigmeProjecteur(Chronometre chrono) {
        super("Le projecteur", chrono);
    }


    @Override
    public void jouer() {


        Scanner scanner = new Scanner(System.in);
        boolean resolu = false;


        System.out.println("Vous entrez dans une cabine sombre.");
        System.out.println("Vous trouvez trois interrupteurs : 1, 2 et 3.");
        System.out.println();
        System.out.println("Votre lampe torche permet d'éclairer le mur.");
        System.out.println("Batterie disponible : " + batterie + "%");


        System.out.print("Appuyez sur entrée pour utiliser la lampe.");
        scanner.nextLine();


        batterie = batterie - 10;


        System.out.println("\nVous éclairez le mur.");
        System.out.println("Une inscription apparaît :");
        System.out.println("\"Le dernier ouvre la marche,");
        System.out.println("le premier vient ensuite,");
        System.out.println("et celui du milieu termine.\"");


        System.out.println("Batterie restante : " + batterie + "%");


        while (!resolu && !chrono.estTermine()) {


            System.out.print("\nEntrez l'ordre des interrupteurs : ");
            String reponse = scanner.nextLine();


            if (reponse.equals("312")) {


                Affichage.reussite("Le projecteur s'allume !");
                System.out.println("Vous avez résolu la deuxième énigme.");
                resolu = true;


            } else {


                Affichage.echec("Le projecteur émet un bruit inquiétant...");
                chrono.ajouterMalus(10);


                System.out.println("Vous perdez 10 secondes.");
                System.out.println("Temps restant : " + chrono.tempsRestant() + " secondes.");
                Affichage.separation();
            }
        }
    }
}
