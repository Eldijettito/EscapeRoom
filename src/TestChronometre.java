package src;

public class TestChronometre {

    public static void main(String[] args) {

        Chronometre chrono = new Chronometre(99);

        chrono.demarrer();

        System.out.println("Temps initial : "
                + chrono.tempsRestant() + " secondes");

        chrono.ajouterMalus(20);

        System.out.println("Après malus : "
                + chrono.tempsRestant() + " secondes");

        System.out.println("Temps écoulé ? "
                + chrono.estTermine());
    }
}
