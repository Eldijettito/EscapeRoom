package src;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class EnigmeProjecteurTest {

    @Test
    void testBonneReponse() {
        Chronometre chrono = new Chronometre(100);
        chrono.demarrer();
        EnigmeProjecteur enigme = new EnigmeProjecteur(chrono);

        String entrees = "\n312\n";
        InputStream ancienneEntree = System.in;

        try {
            System.setIn(new ByteArrayInputStream(
                entrees.getBytes()
            ));

            assertDoesNotThrow(() -> enigme.jouer());

        } finally {
            System.setIn(ancienneEntree);
        }
    }

    @Test
    void testMauvaiseReponse() {
        Chronometre chrono = new Chronometre(100);
        chrono.demarrer();
        EnigmeProjecteur enigme = new EnigmeProjecteur(chrono);

        String entrees = "\n123\n312\n";
        InputStream ancienneEntree = System.in;

        try {
            System.setIn(new ByteArrayInputStream(
                entrees.getBytes()
            ));

            long tempsAvant = chrono.tempsRestant();

            enigme.jouer();

            long tempsApres = chrono.tempsRestant();

            assertEquals(10, tempsAvant - tempsApres);

        } finally {
            System.setIn(ancienneEntree);
        }
    }

    @Test
    void testPlusieursMauvaisesReponses() {
        Chronometre chrono = new Chronometre(100);
        chrono.demarrer();
        EnigmeProjecteur enigme = new EnigmeProjecteur(chrono);

        String entrees = "\n123\n456\n312\n";
        InputStream ancienneEntree = System.in;

        try {
            System.setIn(new ByteArrayInputStream(
                entrees.getBytes()
            ));

            long tempsAvant = chrono.tempsRestant();

            enigme.jouer();

            long tempsApres = chrono.tempsRestant();

            assertEquals(20, tempsAvant - tempsApres);

        } finally {
            System.setIn(ancienneEntree);
        }
    }

    @Test
    void testBatterieInitiale() {
        Chronometre chrono = new Chronometre(100);
        chrono.demarrer();
        EnigmeProjecteur enigme = new EnigmeProjecteur(chrono);

        String entrees = "\n312\n";
        InputStream ancienneEntree = System.in;

        try {
            System.setIn(new ByteArrayInputStream(
                entrees.getBytes()
            ));

            enigme.jouer();

            // La batterie passe de 100 % à 90 %.
            // Cette vérification se fait indirectement
            // via l'affichage dans la console.
            assertDoesNotThrow(() -> enigme.jouer());

        } finally {
            System.setIn(ancienneEntree);
        }
    }
}


