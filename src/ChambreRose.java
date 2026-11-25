package src;
import java.util.ArrayList;

/**
 * Reprsénte la Chambre rose, 4ème niveau du jeu.
 * Le joueur doit résoudre 3 énigmes pour pouvoir s'échapper de la chambre.
 * 
 * @author Margaux Riffard
 */
public class ChambreRose extends Piece implements Jouable {
    private final Chronometre chrono;
    private EtatChambre etat = EtatChambre.VERROUILLEE;
    
    /**
     * Construit la chambre rose et lui associe le chronomètre du jeu.
     * 
     * @param chrono
     */
    public ChambreRose(Chronometre chrono) {
        super("Chambre Rose", 4);
        this.chrono = chrono;
    }

    /**   
     * Afficher la description de la Chambre Rose lors de 
     * l'entrée du joueur dans le niveau
     * 
     * @see src.Piece#afficherDescription()
     */
    @Override 
    public void afficherDescription() {

        Affichage.titre("Niveau 4 : LA CHAMBRE ROSE");
        
        System.out.println("Vous entrez dans une chambre entièrement rose...");
        System.out.println();
        System.out.println("Des poupées en porcelaine vous observent.");
        System.out.println("Une boîte à musique joue toute seule.");

        Affichage.separation();

        System.out.println("Soudain, la porte se verrouille derrière vous.");
        System.out.println();
        System.out.println("Vous devez résoudre les 3 énigmes pour vous échapper.");
    
    }

/**
 * Lance le déroulement du niveau Chambre rose.
 * Présente les trois enigmes au joueur dans l'ordre
 * Vérifie le temps restant après chaque énigme
 * Dévérpouille la porte si toutes les énigmes sont résolues avant la fin du temps imparti.
 * 
 * @see src.Jouable#jouerNiveau()
 */
@Override 
public void jouerNiveau() {

    if (estTerminee()){
        System.out.println("La Chambre Rose est déjà terminée !");
        return;
    }

    afficherDescription();

    ArrayList<Enigme> enigmes = new ArrayList<>();
    enigmes.add(new EnigmePoupees(chrono));
    enigmes.add(new EnigmeMiroir(chrono));
    enigmes.add(new EnigmeBoiteMusique(chrono));

    for (Enigme enigme : enigmes) {

        if (chrono.estTermine()) {
            Affichage.gameOver();
            return;
        }

        enigme.afficherNom();
        enigme.jouer();

        if (chrono.estTermine()) {
            Affichage.gameOver();
            return;
        }
    }

    ouvrirPorte();

}

/**
 * Déverouille la porte de la Chambre Rose
 * Si les 3 énigmes sont résolues
 * Modifie l'état de la chambre
 * Affiche un message de victoire si la porte est déverrouillée
 */
    private void ouvrirPorte(){
       if (etat == EtatChambre.VERROUILLEE){
        etat = EtatChambre.OUVERTE;

        Affichage.victoire("La porte de la chambre rose s'ouvre lentement...\n"
        +"Vous pouvez maintenant passer à la pièce suivante.");
    }
}

/**
 * Vérifie si le niveau est terminé
 * 
 * @return true si la porte est ouverte, false sinon
 */
    public boolean estTerminee(){
        return etat == EtatChambre.OUVERTE;
    }
}

