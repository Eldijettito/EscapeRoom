package src;

/**
 * Fournit des méthodes pour l'affichage de messages dans la console.
 * 
 * @author Margaux Riffard
 */
public class Affichage {

    /**
     * Affiche un titre encadré par des lignes de séparation.
     * 
     * @param texte le texte du titre à afficher
     */
    public static void titre(String texte) {
        System.out.println();
        System.out.println("===========================================");
        System.out.println("      " + texte + " ");
        System.out.println("===========================================");
        System.out.println();
    }

    /**
     * Affiche une ligne de séparation.
     */
    public static void separation() {
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println();
    }

    /**
     * Affiche un message de réussite d'une énigme.
     * 
     * @param message le message de réussite à afficher
     */
    public static void reussite(String message) {
        System.out.println();
        System.out.println(">>> BRAVO ! ");
        System.out.println(message);
        System.out.println();
    }

    /**
     * Affiche un message d'échec d'une énigme.
     * 
     * @param message le message à d'échec à afficher
     */
    public static void echec(String message) {
        System.out.println();
        System.out.println(">>> MAUVAISE RÉPONSE ! ");
        System.out.println(message);
        System.out.println();
    }

    /**
     * Affiche un message de victoire avec un encadré.
     * 
     * @param message le message à afficher
     */
    public static void victoire(String message) {
        System.out.println();
        System.out.println("====================================");
        System.out.println("NIVEAU TERMINÉ !");
        System.out.println("====================================");
        System.out.println();
        System.out.println(message);
        System.out.println();
        System.out.println("====================================");
    }

    /**
     * Affiche un message de fin de partie avec un encadré.
     * Indique que le temps est écoulé et que la porte de la chambre rose reste fermée.
     */
    public static void gameOver() {
        System.out.println();
        System.out.println("====================================");
        System.out.println("GAME OVER !");
        System.out.println("====================================");
        System.out.println();
        System.out.println("Le temps est écoulé.");
        System.out.println("La porte de la chambre rose reste fermée.");
        System.out.println();
        System.out.println("====================================");
    }

}
