package src;
 
import java.util.Scanner;
 
public class ChambreFroide extends Piece implements Jouable {
 
    private boolean enigme1Resolu = false;
    private boolean enigme2Resolu = false;
    private boolean enigme3Resolu = false;
    private final Chronometre chrono;

    private int batterie = 100;
    private int malusTemps = 0;
 
    // Objets du niveau (provisoire, en attendant la classe Inventaire)
    private boolean cleDansInventaire = false;
    private boolean barreDansInventaire = false;
 
    // Constructeur
    public ChambreFroide(Chronometre chrono) {
        super("ChambreFroide", 3);
        this.chrono = chrono;
	
    }
 
    // Description
    @Override
    public void afficherDescription() {
        System.out.println("====================================");
        System.out.println("NIVEAU 3 : LA CHAMBRE FROIDE");
        System.out.println("====================================");
        System.out.println("Vous entrez dans une chambre froide.");
        System.out.println("Les murs sont recouverts de glace.");
        System.out.println("Une silhouette humaine est emprisonnee dans un bloc gele.");
        System.out.println("La porte de sortie est bloquee.");
        System.out.println("Vous devez resoudre 3 enigmes pour sortir.");
        System.out.println("Le chronometre continue de tourner...");
        System.out.println("====================================\n");
    }
 
    // Jouer le niveau
   @Override
public void jouerNiveau() {
    Scanner scanner = new Scanner(System.in);

    if (chrono.estTermine()) {
        Affichage.gameOver();
        return;
    }

    afficherDescription();

    enigme1(scanner);
    if (chrono.estTermine()) {
        Affichage.gameOver();
        return;
    }

    enigme2(scanner);
    if (chrono.estTermine()) {
        Affichage.gameOver();
        return;
    }

    enigme3(scanner);
    if (chrono.estTermine()) {
        Affichage.gameOver();
        return;
    }

    System.out.println("\nFelicitations ! Vous avez termine le niveau 3 !");
    System.out.println("Vous ouvrez la porte et entrez dans une chambre entierement rose...");
    System.out.println("Malus de temps accumules : " + malusTemps + " secondes.");
    System.out.println("Batterie restante : " + batterie + "%");
}
 
    // Enigme 1 : La reaction exothermique
    private void enigme1(Scanner scanner) {
        System.out.println("\nENIGME 1 : LA REACTION EXOTHERMIQUE");
        System.out.println("Une boite metallique est emprisonnee dans la glace.");
        System.out.println("Pres de vous, trois reactifs chimiques sont poses sur une table.");
        System.out.println("Un dispositif ferme permet de dissoudre un reactif dans de l'eau.");
        System.out.println("Il faut choisir celui dont la dissolution libere de la chaleur");
        System.out.println("pour faire fondre la glace.");
 
        while (!enigme1Resolu && !chrono.estTermine()) {
            System.out.println("\nQuel reactif choisissez-vous ?");
            System.out.println("1. Phenol-chloroforme");
            System.out.println("2. Chlorure de calcium anhydre (CaCl2)");
            System.out.println("3. EDTA");
            System.out.print("Votre choix : ");
            String choix = scanner.nextLine();
 
            if (choix.equals("1")) {
                System.out.println("\nMauvaise reponse.");
                expliquerPhenolChloroforme();
                penaliser(10);
            } else if (choix.equals("2")) {
                System.out.println("\nBonne reponse !");
                expliquerCaCl2();
                System.out.println("\nLa glace fond lentement autour de la boite metallique.");
                enigme1Resolu = true;
            } else if (choix.equals("3")) {
                System.out.println("\nMauvaise reponse.");
                expliquerEDTA();
                penaliser(10);
            } else {
                System.out.println("Choix invalide. Tapez 1, 2 ou 3.");
            }
        }
    }
 
    // Explications scientifiques de l'enigme 1
    private void expliquerPhenolChloroforme() {
        System.out.println("Explication : le phenol-chloroforme sert a extraire et separer");
        System.out.println("les acides nucleiques (ADN et ARN) des proteines.");
        System.out.println("Il ne libere pas de chaleur de facon utile ici.");
    }
 
    private void expliquerCaCl2() {
        System.out.println("Explication : la dissolution du chlorure de calcium anhydre");
        System.out.println("dans l'eau est exothermique : elle libere de la chaleur.");
        System.out.println("C'est ce qui permet de faire fondre la glace.");
    }
 
    private void expliquerEDTA() {
        System.out.println("Explication : l'EDTA est un agent chelateur.");
        System.out.println("Il fixe les ions metalliques, mais il ne degage pas de chaleur.");
    }
 
    // Enigme 2 : Le corps congele
    private void enigme2(Scanner scanner) {
        System.out.println("\nENIGME 2 : LE CORPS CONGELE");
        System.out.println("La glace a fondu. Vous recuperez la petite boite metallique.");
        System.out.println("Elle contient une cle et une note.");
        cleDansInventaire = true;
        System.out.println("(Objet obtenu : une cle)");
        System.out.println("\nLa note dit :");
        System.out.println("\"Celui qui detient la sortie ne peut plus ouvrir les yeux.\"");
 
        // Etape 1 : trouver ou chercher
        boolean zoneTrouvee = false;
        while (!zoneTrouvee && !chrono.estTermine()) {
            System.out.println("\nOu cherchez-vous ?");
            System.out.println("1. Le mur de glace");
            System.out.println("2. Le corps congele");
            System.out.println("3. Le sol de la chambre");
            System.out.print("Votre choix : ");
            String choix = scanner.nextLine();
 
            if (choix.equals("2")) {
                zoneTrouvee = true;
            } else if (choix.equals("1") || choix.equals("3")) {
                System.out.println("Vous ne trouvez rien d'interessant ici.");
                penaliser(10);
            } else {
                System.out.println("Choix invalide. Tapez 1, 2 ou 3.");
            }
        }

        if (chrono.estTermine()){
            return;
        }
 
        // Etape 2 : lampe torche
        System.out.println("\nLe corps est dans l'ombre.");
        System.out.println("Batterie disponible : " + batterie + "%");
        System.out.print("Appuyez sur entree pour fouiller avec la lampe.");
        scanner.nextLine();

        if (chrono.estTermine()) {
    return;
}
        batterie = Math.max(0, batterie - 10);
 
        System.out.println("\nVous fouillez la zone sombre avec votre lampe.");
        System.out.println("Derriere le corps gele, vous reperez un casier verrouille.");
        System.out.println("Batterie restante : " + batterie + "%");
 
        // Etape 3 : ouvrir le casier avec la cle
        System.out.print("\nAppuyez sur entree pour utiliser la cle sur le casier.");
        scanner.nextLine();

        if (chrono.estTermine()) {
    return;
}
 
        if (cleDansInventaire) {
            cleDansInventaire = false;
            System.out.println("\nLa cle tourne dans la serrure. Le casier s'ouvre !");
            System.out.println("(La cle disparait de votre inventaire.)");
        }
 
        System.out.println("\nA l'interieur, vous trouvez :");
        System.out.println("- une commande pour arreter le systeme de refroidissement");
        System.out.println("- une barre metallique");
        barreDansInventaire = true;
        System.out.println("(Objet obtenu : une barre metallique)");
 
        System.out.print("\nAppuyez sur entree pour actionner la commande.");
        scanner.nextLine();

        if (chrono.estTermine()) {
    return;
}
 
        System.out.println("\nUn grondement s'arrete. Le systeme de refroidissement est coupe.");
        System.out.println("Mais la porte reste bloquee par la glace...");
        enigme2Resolu = true;
    }
 
    // Enigme 3 : La porte gelee
    private void enigme3(Scanner scanner) {
        System.out.println("\nENIGME 3 : LA PORTE GELEE");
        System.out.println("La porte est completement prise dans la glace.");
 
        while (!enigme3Resolu && !chrono.estTermine()) {
            System.out.println("\nQue faites-vous ?");
            System.out.println("1. Attendre que la glace fonde");
            System.out.println("2. Utiliser la barre metallique pour briser la glace");
            System.out.println("3. Forcer la porte a mains nues");
            System.out.print("Votre choix : ");
            String choix = scanner.nextLine();
 
            if (choix.equals("1")) {
                System.out.println("Vous attendez... mais la glace fond tres lentement.");
                penaliser(10);
            } else if (choix.equals("2")) {
                if (barreDansInventaire) {
                    barreDansInventaire = false;
                    System.out.println("Vous frappez la glace avec la barre metallique.");
                    System.out.println("La glace se brise en mille morceaux !");
                    System.out.println("(La barre metallique est consommee.)");
                    System.out.println("La porte s'ouvre.");
                    enigme3Resolu = true;
                } else {
                    System.out.println("Vous n'avez plus de barre metallique.");
                }
            } else if (choix.equals("3")) {
                System.out.println("Vos mains collent a la glace. Ca fait tres mal !");
                penaliser(10);
            } else {
                System.out.println("Choix invalide. Tapez 1, 2 ou 3.");
            }
        }
    }
 
    // Malus de temps
    private void penaliser(int secondes) {
        System.out.println("Vous perdez " + secondes + " secondes.");
        malusTemps = malusTemps + secondes;
        chrono.ajouterMalus(secondes);
    }

    /**
 * Vérifie si les trois énigmes ont été résolues
 * avant l'expiration du chronomètre.
 *
 * @return true si le niveau est terminé, false sinon
 */
public boolean estTerminee() {
    return enigme1Resolu
        && enigme2Resolu
        && enigme3Resolu
        && !chrono.estTermine();
}
}

