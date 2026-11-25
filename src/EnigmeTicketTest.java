package src;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class EnigmeTicketTest {

    @Test
    void testBonneReponse() {
        Chronometre chrono = new Chronometre(100);
        chrono.demarrer();
        EnigmeTicket enigme = new EnigmeTicket(chrono);

        String entrees = "443\n";
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
        EnigmeTicket enigme = new EnigmeTicket(chrono);

        String entrees = "123\n443\n";
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
        EnigmeTicket enigme = new EnigmeTicket(chrono);

        String entrees = "123\n456\n443\n";
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
    
}
