package src;

/**
 * Représente un chronomètre pour mesurer le temps restant dans le jeu.
 * Il permet de démarrer le chronomètre, d'ajouter des pénalités de temps, 
 * de vérifier le temps restant et de déterminer si le temps est écoulé.
 * 
 * @author Margaux Riffard
 */
public class Chronometre {
    private long debut;
    private long duree;
    private long penalites;

    /**
     * Construit un chronomètre avec une durée spécifiée en secondes.
     * 
     * @param dureeSecondes la durée initiale du chronomètre en secondes
     */
    public Chronometre(long dureeSecondes){
        this.duree = dureeSecondes * 1_000_000_000L; // Convertir en nanosecondes
        this.penalites = 0;
        this.debut = 0;
    }

    /**
     * Démarre le chronomètre en enregistrant le moment de départ
     */
    public void demarrer(){
        this.debut = System.nanoTime();
    }

    /**
     * Calcule le temps restant en soustrayant le temps écoulé depuis le début et les pénalités
     * 
     * @return le temps restant en seconde, ou 0 si temps écoulé
     */
    public long tempsRestant(){
        long tempsEcoule = System.nanoTime() - debut;
        long restant = duree - tempsEcoule - penalites;
        return Math.max(0, restant / 1_000_000_000L); // Retourner 0 si le temps est écoulé
    }

    /**
     * Ajouter une pénalité qui réduit le temps restant 
     * 
     * @param secondes de nombre de seconde de pénalité à ajouter
     */
    public void ajouterMalus (long secondes){
        if (secondes > 0) {
            penalites += secondes * 1_000_000_000L; // Convertir en nanosecondes
        }
    }

    /**
     * Vérifie si le temps dispo est écoulé
     * 
     * @return tru si le temps restant est nul, sinon false
     */
    public boolean estTermine(){
        return tempsRestant() <= 0;
    }
}