
package src;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Regroupe les test unitaire de Chambre Rose
 * Vérifie ses caractéristiques, sont état initial
 * son héritage et l'implantation de l'interface jouable
 * 
 * @author Margaux Riffard
 */
public class ChambreRoseTest {

    /**
     * Vérifie que le chrono n'est pas terminé avant le début du niveau
     */
    @Test
    void testChambreNonTermineeAuDepart() {
        Chronometre chrono = new Chronometre(100);
        ChambreRose chambre = new ChambreRose(chrono);

        assertFalse(chambre.estTerminee());
    }

    /**
     * Vérifie que le nom et la chambre son bien introduit par le constructeur
     */
    @Test
    void testNomChambre() {
        Chronometre chrono = new Chronometre(100);
        ChambreRose chambre = new ChambreRose(chrono);

        assertEquals("Chambre Rose", chambre.getNom());
    }

    /**
     * Vérifie que le numéro de niveau est corréctement donnée
     */
    @Test
    void testNumeroChambre() {
        Chronometre chrono = new Chronometre(100);
        ChambreRose chambre = new ChambreRose(chrono);

        assertEquals(4, chambre.getNumero());
    }

    @Test
    void testChambreEstUnePiece() {
        Chronometre chrono = new Chronometre(100);
        ChambreRose chambre = new ChambreRose(chrono);

        assertInstanceOf(Piece.class, chambre);
    }

    @Test
    void testChambreEstJouable() {
        Chronometre chrono = new Chronometre(100);
        ChambreRose chambre = new ChambreRose(chrono);

        assertInstanceOf(Jouable.class, chambre);
    }
}
