package src;

public class Main {
    public static void main(String[] args) {

        Chronometre chrono = new Chronometre(1800);
        chrono.demarrer();

        Cinema cinema = new Cinema(chrono);
        ChambreRose chambre = new ChambreRose(chrono);

        System.out.println("Niveau" + cinema.getNumero());
        System.out.println("Nom de la pièce: " + cinema.getNom());

        cinema.jouerNiveau();

if (!cinema.estTerminee() || chrono.estTermine()) {
    System.out.println("Fin de la partie !");
    return;
}

ChambreFroide chambreFroide = new ChambreFroide(chrono);
chambreFroide.jouerNiveau();

if (!chambreFroide.estTerminee() || chrono.estTermine()) {
    System.out.println("Fin de la partie !");
    return;
}

chambre.jouerNiveau();

if (!chambre.estTerminee() || chrono.estTermine()) {
    System.out.println("Fin de la partie !");
    return;
}

    Cave cave = new Cave(chrono);
    cave.jouerNiveau();

if (!cave.estTerminee() || chrono.estTermine()) {
    System.out.println("Fin de la partie !");
    return;
}
    Foret foret = new Foret(chrono);
    foret.jouerNiveau();

if (!foret.estTerminee() || chrono.estTermine()) {
    System.out.println("Fin de la partie !");
    return;
}
}
}