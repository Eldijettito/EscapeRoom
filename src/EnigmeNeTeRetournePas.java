package src;
import java.util.Scanner;


/**
 * Représente la troisième énigme du cinéma.
 * Le joueur doit récupérer une clé sans se faire surprendre par une silhouette.
 *
 * @author Fanny Bouffard
 */
public class EnigmeNeTeRetournePas extends Enigme {


    public EnigmeNeTeRetournePas(Chronometre chrono) {
        super("Ne te retourne pas", chrono);
    }


    @Override
    public void jouer() {


        Scanner scanner = new Scanner(System.in);
        boolean resolu = false;


        System.out.println("Le projecteur s'arrête brutalement.");
        System.out.println("Vous entendez des pas derrière vous.");
        System.out.println("Une voix murmure :");
        System.out.println("\"Ne te retourne surtout pas...\"");
        System.out.println("Vous apercevez une clé sur un bureau.");


        while (!resolu && !chrono.estTermine()) {


            System.out.println("\nQue faites-vous ?");
            System.out.println("1. Se retourner");
            System.out.println("2. Prendre la clé et courir vers la porte");
            System.out.println("3. Éteindre la lampe et rester immobile");


            System.out.print("Votre choix : ");
            String choix = scanner.nextLine();


            if (choix.equals("1")) {


                Affichage.echec("Une silhouette sans visage apparaît !");
                chrono.ajouterMalus(10);


                System.out.println("Vous perdez 10 secondes.");
                System.out.println("Temps restant : " + chrono.tempsRestant() + " secondes.");


            } else if (choix.equals("2")) {


                Affichage.reussite("Vous prenez la clé et courez vers la porte !");
                System.out.println("Vous avez réussi à sortir du cinéma.");
                resolu = true;


            } else if (choix.equals("3")) {


                System.out.println("La clé disparaît !");
                System.out.println("Vous devez résoudre une dernière petite énigme.");


                System.out.println("\nUne inscription apparaît sur le bureau.");
                System.out.println("Combien de voyelles contient le texte :");
                System.out.println("\"BIENVENUE AU CINEMA\" ?");


                System.out.print("Votre réponse : ");
                String reponse = scanner.nextLine();


                if (reponse.equals("9")) {


                    Affichage.reussite("La clé réapparaît sur le bureau !");
                    System.out.println("Vous pouvez maintenant la récupérer.");


                } else {


                    Affichage.echec("L'inscription disparaît...");
                    chrono.ajouterMalus(10);


                    System.out.println("Mauvaise réponse !");
                    System.out.println("Vous perdez 10 secondes.");
                    System.out.println("Temps restant : " + chrono.tempsRestant() + " secondes.");
                }


            } else {


                System.out.println("Choix invalide. Tapez 1, 2 ou 3.");
            }
        }
    }
}
