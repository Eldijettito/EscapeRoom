package src;

/**
 * Représente une entité jouable dans le jeu.
 * Les classes qui implémentent cette interface doivent fournir une implémentation de la méthode jouerNiveau(), 
 * qui définit le déroulement du niveau de jeu associé à l'entité.
 * 
 * @author Margaux Riffard
 * Jouable
 */
public interface Jouable {

    /**
     * Lance le déroulement du niveau du jeu
     * Chaque classe implémente cette interface définit
     * les actions et les énigmes propres à son niveau
     */
    void jouerNiveau();

}
