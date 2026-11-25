package src;
import java.util.Scanner;

public class EnigmePetiteSalle extends Enigme {

    // Variable pour simuler la possession de la clé (ou liée à votre gestion d'inventaire)
    private static boolean possedeCleRouillee = true; 

    public EnigmePetiteSalle(Chronometre chrono) {
        super("La Petite Salle Secrète", chrono);
    }

    @Override
    public void jouer() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Vous arrivez dans un couloir sombre doté d'une petite porte fermée par un vieux cadenas rouillé.");

        if (!possedeCleRouillee) {
            Affichage.echec("La porte est verrouillée. Il vous manque la petite clé rouillée ! Explorez d'abord la bibliothèque.");
            return;
        }

        System.out.println("Vous insérez la petite clé... Clic ! La porte s'ouvre. Vous entrez dans la pièce exiguë.");
        System.out.println("Sur un mur taché de suie, une phrase énigmatique est tracée au sang : ");
        System.out.println(" ➔ 'Mon double, augmenté de six, permet d'atteindre dix. Quel est ce chiffre ?'");
        
        boolean reussite = false;
        while (!reussite) {
            System.out.print("Entrez votre réponse : ");
            String reponse = scanner.nextLine().trim();

            // Résolution : 2 * x + 6 = 10 ==> 2 * x = 4 ==> x = 2
            if (reponse.equals("2")) {
                Affichage.reussite("Le mur pivote légèrement ! Un dernier indice se révèle : [ 5 ].\n" +
                                   "Vous emparez de l'information et repartez en courant vers la salle principale du coffre.");
                reussite = true;
            } else {
                Affichage.echec("Rien ne se passe. Le mécanisme reste sourd à cette réponse. Réessayez.");
            }
        }
    }
}