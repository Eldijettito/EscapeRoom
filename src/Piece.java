package src;

/**
 * Représente une pièce du jeu d'évasion
 * Cette classe abstraite définit les caractérques communes
 * aux différentes pièces : leur nom et leur numéro du niveau
 * 
 * Chaque classe fille doit implémenter la méthode
 * afficherDescription() pour présenter sa propre pièce
 * 
 * @author Margaux Riffard
 */
public abstract class Piece {
    private String nom;
    private int numero;

    /**
     * Construit la pièce avec un nom et un numéro de niveau
     * @param nom de la pièce
     * @param numero du niveau
     */
    public Piece(String nom, int numero) {
        this.nom = nom;
        this.numero = numero;
    }

    /**
     * Retourne le nom de la pièce
     * 
     * @return le nom de la pièce
     */
    public String getNom() {
        return nom;
    }

    /**
     * retourne le numéro de la ppièce
     * 
     * @return numéro de la pièce
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Afficher la description de la pièce lors de l'entrée du joueur
     * Chaque classe fille doit définir sa propre description
     */
    public abstract void afficherDescription();
    
}
