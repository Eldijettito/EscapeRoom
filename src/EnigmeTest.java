
package src;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class EnigmeTest {

    private String simuler(String reponses, Runnable action) {
        InputStream entreeOriginale = System.in;
        PrintStream sortieOriginale = System.out;
        ByteArrayOutputStream sortie = new ByteArrayOutputStream();

        try {
            System.setIn(new ByteArrayInputStream(
                reponses.getBytes(StandardCharsets.UTF_8)
            ));
            System.setOut(new PrintStream(sortie, true, StandardCharsets.UTF_8));

            action.run();

            return sortie.toString(StandardCharsets.UTF_8);
        } finally {
            System.setIn(entreeOriginale);
            System.setOut(sortieOriginale);
        }
    }

    @Test
    void testPoupeesBonneReponse() {
        Chronometre chrono = new Chronometre(100);
        chrono.demarrer();

        String resultat = simuler("1\n",
            () -> new EnigmePoupees(chrono).jouer());

        assertTrue(resultat.contains("BRAVO"));
    }

    @Test
    void testPoupeesMauvaiseReponse() {
        Chronometre chrono = new Chronometre(100);
        chrono.demarrer();

        String resultat = simuler("2\n1\n",
            () -> new EnigmePoupees(chrono).jouer());

        assertTrue(resultat.contains("Pénalité : -10 secondes"));
        assertTrue(resultat.contains("BRAVO"));
        assertTrue(chrono.tempsRestant() <= 90);
    }

    @Test
    void testPoupeesSaisieInvalide() {
        Chronometre chrono = new Chronometre(100);
        chrono.demarrer();

        String resultat = simuler("abc\n1\n",
            () -> new EnigmePoupees(chrono).jouer());

        assertTrue(resultat.contains("Réponse invalide"));
        assertTrue(resultat.contains("BRAVO"));
    }

    @Test
    void testMiroirBonneReponse() {
        Chronometre chrono = new Chronometre(100);
        chrono.demarrer();

        String resultat = simuler("3\n",
            () -> new EnigmeMiroir(chrono).jouer());

        assertTrue(resultat.contains("BRAVO"));
    }

    @Test
    void testMiroirMauvaiseReponse() {
        Chronometre chrono = new Chronometre(100);
        chrono.demarrer();

        String resultat = simuler("1\n3\n",
            () -> new EnigmeMiroir(chrono).jouer());

        assertTrue(resultat.contains("Pénalité : -10 secondes"));
        assertTrue(resultat.contains("BRAVO"));
        assertTrue(chrono.tempsRestant() <= 90);
    }

    @Test
    void testMiroirSaisieInvalide() {
        Chronometre chrono = new Chronometre(100);
        chrono.demarrer();

        String resultat = simuler("abc\n3\n",
            () -> new EnigmeMiroir(chrono).jouer());

        assertTrue(resultat.contains("Réponse invalide"));
        assertTrue(resultat.contains("BRAVO"));
    }

    @Test
    void testBoiteBonneReponse() {
        Chronometre chrono = new Chronometre(100);
        chrono.demarrer();

        String resultat = simuler("4271\n",
            () -> new EnigmeBoiteMusique(chrono).jouer());

        assertTrue(resultat.contains("BRAVO"));
    }

    @Test
    void testBoiteMauvaiseReponse() {
        Chronometre chrono = new Chronometre(100);
        chrono.demarrer();

        String resultat = simuler("1234\n4271\n",
            () -> new EnigmeBoiteMusique(chrono).jouer());

        assertTrue(resultat.contains("Pénalité : -15 secondes"));
        assertTrue(resultat.contains("BRAVO"));
        assertTrue(chrono.tempsRestant() <= 85);
    }

    @Test
    void testBoiteSaisieInvalide() {
        Chronometre chrono = new Chronometre(100);
        chrono.demarrer();

        String resultat = simuler("abc\n4271\n",
            () -> new EnigmeBoiteMusique(chrono).jouer());

        assertTrue(resultat.contains("Réponse invalide"));
        assertTrue(resultat.contains("BRAVO"));
    }
}
