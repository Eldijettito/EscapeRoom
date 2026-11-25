
package src;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.nio.charset.StandardCharsets;

/**
 * 
 * 
 * ChambreRoseIT
 */
public class ChambreRoseIT {

    private void simulerReponses(String reponses, Runnable action) {
        InputStream entreeOriginale = System.in;

        try (PipedInputStream entree = new PipedInputStream();
             PipedOutputStream sortie = new PipedOutputStream(entree)) {

            System.setIn(entree);

            Thread joueur = new Thread(() -> {
                try {
                    for (String reponse : reponses.split("\n")) {
                        sortie.write(
                            (reponse + "\n").getBytes(StandardCharsets.UTF_8)
                        );
                        sortie.flush();

                        // Laisse chaque énigme lire sa réponse
                        Thread.sleep(200);
                    }
                } catch (IOException | InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            joueur.start();
            action.run();
            joueur.join();

        } catch (IOException | InterruptedException e) {
            fail("Erreur pendant la simulation : " + e.getMessage());
        } finally {
            System.setIn(entreeOriginale);
        }
    }

    @Test
    void testChambreComplete() {
        Chronometre chrono = new Chronometre(100);
        chrono.demarrer();

        ChambreRose chambre = new ChambreRose(chrono);

        simulerReponses("1\n3\n4271\n",
            () -> chambre.jouerNiveau());

        assertTrue(chambre.estTerminee());
    }

    @Test
    void testChambreAvecErreurs() {
        Chronometre chrono = new Chronometre(100);
        chrono.demarrer();

        ChambreRose chambre = new ChambreRose(chrono);

        simulerReponses("2\n1\n1\n3\n1234\n4271\n",
            () -> chambre.jouerNiveau());

        assertTrue(chambre.estTerminee());
        assertTrue(chrono.tempsRestant() <= 65);
    }

    @Test
    void testGameOver() {
        Chronometre chrono = new Chronometre(100);
        chrono.demarrer();
        chrono.ajouterMalus(100);

        ChambreRose chambre = new ChambreRose(chrono);

        chambre.jouerNiveau();

        assertFalse(chambre.estTerminee());
        assertTrue(chrono.estTermine());
    }

    @Test
    void testChambreDejaTerminee() {
        Chronometre chrono = new Chronometre(100);
        chrono.demarrer();

        ChambreRose chambre = new ChambreRose(chrono);

        simulerReponses("1\n3\n4271\n",
            () -> chambre.jouerNiveau());

        assertTrue(chambre.estTerminee());

        chambre.jouerNiveau();

        assertTrue(chambre.estTerminee());
    }
}
