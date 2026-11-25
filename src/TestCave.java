
package src;

public class TestCave {
    public static void main(String[] args) {

        Chronometre chrono = new Chronometre(1800);
        chrono.demarrer();
        
        Cave chambre = new Cave(chrono);

        chambre.afficherDescription();

    }
}
