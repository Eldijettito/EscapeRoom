package src;

public class TestForet {
    public static void main(String[] args) {
        Chronometre chrono = new Chronometre(600);
        chrono.demarrer();

        Foret foret = new Foret(chrono);

        foret.jouerNiveau();
    }
}
