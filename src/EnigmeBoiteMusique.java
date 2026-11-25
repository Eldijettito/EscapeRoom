package src;

import java.util.Scanner;

/**
 * Représente l'énigme de la boîte à musique, 3ème énigme du niveau Chambre rose.
 * Le joueur doit mémoriser une séquence de chiffres pour résoudre l'énigme
 * 
 * @author Margaux Riffard
 * EnigmeBoiteMusique
 */
public class EnigmeBoiteMusique extends Enigme {

    /**
     * Construit l'énigme de la boîte à musique et lui associe le chronomètre du jeu.
     * 
     * @param chrono le chronomètre du jeu
     */
    public EnigmeBoiteMusique(Chronometre chrono) {
        super("Enigme Boîte à Musique", chrono);
    }
    
    /**  
     * Lance le déroulement de l'énigme de la boîte à musique.
     * Le joueur doit mémoriser une séquence de chiffres pour résoudre l'énigme.
     * Vérifie le temps restant après chaque réponse.   
     * 
     * @see src.Enigme#jouer()
     */
    @Override
    public void jouer() {

        System.out.println("Vous insérez la petite clé dorée dans la boîte à musique.");
        System.out.println("Le couvercle s'ouvre lentement...");

        System.out.println("Une mélodie inquiétante commence à jouer.");
        System.out.println("Quatre chiffres lumineux apparaissent à l'intérieur.");

        Affichage.separation();

        System.out.println("MEMORISEZ LA SÉQUENCE !");
        System.out.println("\nVous avez seulement 3 secondes...");
        System.out.println();
        System.out.println("          [4 - 2 - 7 - 1]          ");

        Affichage.separation();

    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }

    for (int i = 0; i < 50; i++) {
        System.out.println();
    }

    System.out.println("Les chiffres ont disparu !");


Scanner scanner = new Scanner(System.in);

int reponse = 0;

while (reponse != 4271 && !chrono.estTermine()) {

    System.out.print("Entrez les 4 chiffres dans le bon ordre : ");
    if (scanner.hasNextInt()) {
    reponse = scanner.nextInt();
} else {
    scanner.next();
    reponse = 0;
    System.out.println("Réponse invalide ! Entrez les 4 chiffres.");
    continue;
}

if (chrono.estTermine()) {
        return;
    }
    if (reponse == 4271) {
        Affichage.reussite("La boîte à musique s'arrête brusquement...");
        System.out.println("Un compartiment secret s'ouvre !");
        System.out.println("Vous avez réussi la dernière énigme !");

    } else {
        Affichage.echec("Une mélodie stridente retentit !");
        chrono.ajouterMalus(15);

        System.out.println("Pénalité : -15 secondes");
        System.out.println("Temps restant : " + chrono.tempsRestant() + " secondes");

        Affichage.separation();
    }
    }
}
}
