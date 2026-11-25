package src;

public class TestEnigmePoupees {
    public static void main(String[] args) {
        Chronometre chrono = new Chronometre(1800);
        chrono.demarrer();

        EnigmePoupees enigme = new EnigmePoupees(chrono);
        enigme.jouer();
    }
}
