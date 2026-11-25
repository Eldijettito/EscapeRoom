
package src;

public class TestJustePrix {
    public static void main(String[] args) {
        Chronometre chrono = new Chronometre(1800);
        chrono.demarrer();

        JustePrix jeu = new JustePrix(chrono);
        jeu.jouer();
    }
}
