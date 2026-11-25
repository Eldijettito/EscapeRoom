package src;
import java.util.Scanner;

public class EnigmeMorse extends Enigme {

    public EnigmeMorse(Chronometre chrono) {
        super("La Porte et le Morse", chrono);
    }

    @Override
    public void jouer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vous courez vers le fond de la cave pour fuir, mais...");
        System.out.println("La porte est fermée à double tour ! Un terminal lumineux clignote à côté d'elle.");
        System.out.println("Sur l'écran, un signal en Morse clignote lourdement : '.----+..---+.....'");
        System.out.println("Un mémo de correspondance est collé sur le terminal : (.---- = 1, ..--- = 2, ...-- = 3, ....- = 4, ..... = 5, -.... = 6, --... = 7)");
        System.out.print("Entrez le chiffre correspondant au signal Morse : ");
        
        String reponse = scanner.nextLine().trim();
        if (reponse.equals("7")) {
            Affichage.reussite("Bip vert ! Le terminal valide le code. Chiffre débloqué : [ 7 ]");
        } else {
            Affichage.echec("Erreur... Le terminal bourdonne, mais valide l'indice par défaut (7).");
        }
    }
}