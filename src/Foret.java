package src;

import java.util.Scanner;

public class Foret extends Piece implements Jouable {

    private Chronometre chrono;
    private boolean enigmeFinaleResolue = false;
    private int nbErreurs = 0;

    // Code final à 5 chiffres : un chiffre par niveau précédent.
    // ATTENTION : valeurs PROVISOIRES, à remplacer quand les autres niveaux seront finalisés.
    // Cinéma (ticket 443) -> 1er chiffre : 4
    // Hôpital (dossier médical) -> à définir : 5 (provisoire)
    // Pièce glacée (bon réactif = choix n°2, CaCl2) -> 2
    // Chambre rose (séquence 4271) -> 1er chiffre : 4
    // Cave (coffre) -> à définir : 7 (provisoire)
    private static final String CODE_FINAL = "45247";

    // Indices progressifs (après 1, 2 et 3 erreurs)
    private static final String[] INDICES = {
        "Indice 1 : Le code contient cinq chiffres, un par lieu que vous avez traversé.",
        "Indice 2 : Les chiffres suivent l'ordre de votre parcours : Cinéma, Hôpital, Pièce glacée, Chambre rose, Cave.",
        "Indice 3 : Cinéma = 1er chiffre du ticket. Pièce glacée = numéro du bon réactif. Chambre rose = 1er chiffre de la séquence de la boîte à musique."
    };

    // Constructeur
    
    public Foret(Chronometre chrono) {
        super("Foret", 6);
        this.chrono = chrono;
    }

    @Override
    public void afficherDescription() {
        System.out.println("====================================");
        System.out.println("NIVEAU 6 : LE DERNIER SOUVENIR");
        System.out.println("====================================");
        System.out.println("Vous sortez de la cave et arrivez dans une forêt plongée dans le brouillard.");
        System.out.println("Au loin, vous apercevez un portail métallique. Derrière ce portail se trouve la sortie de l'Escape Game.");
        System.out.println("Sur le portail, une inscription apparaît :");
        System.out.println("« Cinq lieux. Cinq souvenirs. Une seule issue... »");
        System.out.println("====================================\n");
    }

    // Jouer le niveau
    @Override 
    public void jouerNiveau() {

        Scanner scanner = new Scanner(System.in);

        afficherDescription();

        enigmeCinqSouvenirs(scanner);

        if (chrono.estTermine()) {
            finMortelle();
        } else {
            finVivante();
        }
    }

    // Enigme finale : les cinq souvenirs
    private void enigmeCinqSouvenirs(Scanner scanner) {

        System.out.println("\nENIGME FINALE : LES CINQ SOUVENIRS");
        pause(1000);
        System.out.println("Le portail est verrouillé par un cadenas à cinq chiffres.");
        System.out.println("Gravés sur le métal, cinq symboles vous rappellent votre parcours :");
        System.out.println("1. Le cinéma        : un indice de la dernière séance");
        System.out.println("2. L'hôpital        : une information du dossier médical");
        System.out.println("3. La pièce glacée  : la réaction chimique");
        System.out.println("4. La chambre rose  : la boîte à musique");
        System.out.println("5. La cave          : un indice découvert pendant l'exploration");
        System.out.println("\nLe brouillard s'épaissit autour de vous...");

        while (!enigmeFinaleResolue && !chrono.estTermine()) {

            System.out.println("\nTemps restant : " + chrono.tempsRestant() + " secondes");
            System.out.print("Entrez le code à cinq chiffres : ");
            String reponse = scanner.nextLine().trim();

            if (!reponse.matches("\\d{5}")) {

                System.out.println("Le cadenas attend exactement cinq chiffres.");

            } else if (reponse.equals(CODE_FINAL)) {

                System.out.println("Le cadenas s'ouvre dans un déclic...");
                enigmeFinaleResolue = true;

            } else {

                nbErreurs++;
                System.out.println("Le cadenas reste fermé. Le brouillard se rapproche...");
                System.out.println("Mauvaise réponse ! Vous perdez 10 secondes.");
                chrono.ajouterMalus(10);
                donnerIndice();
            }
        }
    }

    // Indices progressifs : 1 indice par erreur, jusqu'à 3
    private void donnerIndice() {
        if (nbErreurs <= INDICES.length) {
            System.out.println("\n" + INDICES[nbErreurs - 1]);
        } else {
            System.out.println("\nPlus d'indice disponible. Essayez encore !");
        }
    }

    // Fin vivante
    private void finVivante() {
        System.out.println("\nLe portail métallique s'ouvre lentement.");
        System.out.println("Le brouillard se dissipe et la lumière du jour vous aveugle.");
        System.out.println("Vous avez réussi à vous échapper vivant !");
        System.out.println("Temps restant : " + chrono.tempsRestant() + " secondes");
        System.out.println("\n=== FIN : VOUS ETES LIBRE ===");
    }

    // Fin mortelle
    private void finMortelle() {
        System.out.println("\nLe chronomètre atteint zéro...");
        pause(1000);
        System.out.println("Le brouillard vous engloutit.");
        pause(1000);
        System.out.println("\nGAME OVER ! Le temps est écoulé.");
        System.out.println("\n=== FIN : VOUS N'AVEZ PAS SURVECU ===");
    }

    // Petite pause pour l'ambiance
    private void pause(int millisecondes) {
        try {
            Thread.sleep(millisecondes);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
 * Vérifie si le joueur a réussi l'énigme finale
 * avant la fin du chronomètre.
 *
 * @return true si le joueur s'est échappé, false sinon
 */
public boolean estTerminee() {
    return enigmeFinaleResolue && !chrono.estTermine();
}
}
