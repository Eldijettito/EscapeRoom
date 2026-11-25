package src;

public class TestEnigmeBoiteMusique {
    public static void main(String[] args) {
        Chronometre chrono = new Chronometre(1800);
        chrono.demarrer();

        EnigmeBoiteMusique enigme = new EnigmeBoiteMusique(chrono);
        enigme.jouer();
    }
}
