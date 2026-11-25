package src;

public class TestEnigmeMiroir {
    public static void main(String[] args) {
        Chronometre chrono = new Chronometre(1800);
        chrono.demarrer();

        EnigmeMiroir enigme = new EnigmeMiroir(chrono);
        enigme.jouer();
    }
}
