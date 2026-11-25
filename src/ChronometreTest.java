
package src;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Regroupe les tests unitaires du chronomètre
 * Vérifie les pénalités, te temps restant et la détection de la fin du temps
 * 
 * @author Margaux Riffard
 */
public class ChronometreTest {

    /**
     * Vérifie qu'une pénalité réduit le temps restant
     */
    @Test
    void testAjouterMalus() {
        Chronometre chrono = new Chronometre(100);
        chrono.demarrer();

        chrono.ajouterMalus(20);

        long restant = chrono.tempsRestant();

        assertTrue(restant >= 79 && restant <= 80);
    }

    /**
     * Vérifie que le chronomètre est terminé lorsque le temps est écoulé
     */
    @Test
    void testEstTermine() {
        Chronometre chrono = new Chronometre(100);
        chrono.demarrer();

        chrono.ajouterMalus(100);

        assertTrue(chrono.estTermine());
}

/**
 * Vérifie que le chrono n'est pas terminé au démarrage
 */
@Test
void testChronometreNonTermine() {
    Chronometre chrono = new Chronometre(100);
    chrono.demarrer();

    assertFalse(chrono.estTermine());
}

/**
 * Vérifie qu'une pénalité négative est ignorée
 */
@Test
void testMalusNegatifIgnore() {
    Chronometre chrono = new Chronometre(100);
    chrono.demarrer();

    long avant = chrono.tempsRestant();

    chrono.ajouterMalus(-20);

    long apres = chrono.tempsRestant();

    assertTrue(apres >= avant - 1);
}

/**
 * Vérifie que le temps restant ne devient pas négatif
 */
@Test
void testTempsRestantJamaisNegatif() {
    Chronometre chrono = new Chronometre(100);
    chrono.demarrer();

    chrono.ajouterMalus(200);

    assertEquals(0, chrono.tempsRestant());
}

}
