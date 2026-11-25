package src;


public class TestCinema{

    public static void main(String[] args) {
        Chronometre chrono = new Chronometre(600);
        chrono.demarrer();

        // Creation du cinema
        Cinema cinema = new Cinema(chrono);

        // Lancement du niveau
        cinema.jouerNiveau();

    }
}
