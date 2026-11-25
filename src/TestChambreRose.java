package src;

public class TestChambreRose {
    public static void main(String[] args) {
        Chronometre chrono = new Chronometre(1800);
        chrono.demarrer();

        ChambreRose chambre = new ChambreRose(chrono);

        chambre.jouerNiveau();

        System.out.println("\nLe niveau est terminé : " + chambre.estTerminee());
    }
}
