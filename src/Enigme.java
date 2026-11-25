package src;

/**
 * Reprséente une énigme du jeu
 * Classe abstraite qui définit les caractéristiques communes à toutes les énigmes
 * = nom et chronomètre
 * 
 * @author Margaux Riffard
 * Enigme
 */
public abstract class Enigme {
    private final String nom;
    protected final Chronometre chrono;

    /**
     * Initialise une énigme avec un nom et un chronomètre
     * @param nom de l'énigme
     * @param chrono partagé entre les énigmes
     */
    public Enigme(String nom, Chronometre chrono) {
        this.nom = nom;
        this.chrono = chrono;
    }

    /**
     * Retourne le nom de l'énigme
     * 
     * @return le nom de l'énigme
     */
    public String getNom() {
        return nom;
    }

    /**
     * Affiche le nom de l'énigme en majuscules
     */
    public void afficherNom(){
        Affichage.titre(nom.toUpperCase());
    }

    /**
     * Lance le déroulement de l'énigme
     */
    public abstract void jouer();
}
