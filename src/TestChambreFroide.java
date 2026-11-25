package src;

public class TestChambreFroide {
    public static void main(String[] args) {
        Chronometre chrono = new Chronometre(1800);
        chrono.demarrer();

        ChambreFroide chambre = new ChambreFroide(chrono);

        chambre.jouerNiveau();
    }
}

