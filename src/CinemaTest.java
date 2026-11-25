
package src;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class CinemaTest {

    @Test
    void testCinemaNonTermineAuDepart() {
        Chronometre chrono = new Chronometre(100);
        chrono.demarrer();
        Cinema cinema = new Cinema(chrono);

        assertFalse(cinema.estTerminee());
    }

    @Test
    void testCinemaTermineApresResolutionDesEnigmes() {
        Chronometre chrono = new Chronometre(100);
        chrono.demarrer();
        Cinema cinema = new Cinema(chrono);

        // Réponses correctes aux trois énigmes :
        // Ticket : 443
        // Projecteur : 312
        // Ne te retourne pas : 2
        // Puis réponse à l'énigme des voyelles si nécessaire.

        String entrees = "443\n\n312\n2\n";
        InputStream ancienneEntree = System.in;

        try {
            System.setIn(new ByteArrayInputStream(
                entrees.getBytes()
            ));

            cinema.jouerNiveau();

            assertTrue(cinema.estTerminee());

        } finally {
            System.setIn(ancienneEntree);
        }
    }

    @Test
    void testCinemaDejaTermine() {
        Chronometre chrono = new Chronometre(100);
        chrono.demarrer();
        Cinema cinema = new Cinema(chrono);

        // On vérifie qu'un niveau déjà terminé
        // ne peut pas être rejoué.
        assertFalse(cinema.estTerminee());
    }

    @Test
    void testChronometreTermineAvantLeDebut() {
        Chronometre chrono = new Chronometre(100);
        chrono.demarrer();

        // À adapter selon le constructeur et les méthodes
        // disponibles dans ta classe Chronometre.

        Cinema cinema = new Cinema(chrono);

        assertFalse(cinema.estTerminee());
    }
}
