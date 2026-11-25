package src;
import java.util.ArrayList;

/**
 * Représente la Cave, niveau du jeu.
 * Le joueur doit traverser les étapes et résoudre les énigmes pour s'échapper.
 */
public class Cave extends Piece implements Jouable {
    private final Chronometre chrono;
    private EtatChambre etat = EtatChambre.VERROUILLEE;

    /**
     * Construit la cave et lui associe le chronomètre du jeu.
     * 
     * @param chrono le chronomètre partagé
     */
    public Cave(Chronometre chrono) {
        super("Cave", 5);
        this.chrono = chrono;
    }

    @Override
    public void afficherDescription() {
        Affichage.titre("Niveau 5 : LA CAVE");
        
        System.out.println("Vous reprenez conscience dans une obscurité totale, le crâne en feu.");
        System.out.println("Vous avez le goût du sang dans la bouche : quelqu'un vous a assommé.");
        System.out.println("Encore allongé sur le sol glacé et poisseux, vous vous relevez en sursaut...");
        
        Affichage.separation();
    }

    @Override
    public void jouerNiveau() {
        if (estTerminee()) {
            System.out.println("La Cave est déjà terminée !");
            return;
        }

        afficherDescription();

        // On liste les énigmes/étapes de façon linéaire, héritant toutes de Enigme
        ArrayList<Enigme> enigmes = new ArrayList<>();
        enigmes.add(new EnigmeMorse(chrono));
        enigmes.add(new EnigmeLit(chrono));
        enigmes.add(new EnigmeBibliotheque(chrono));
        enigmes.add(new EnigmePetiteSalle(chrono));
        enigmes.add(new EnigmeCoffre(chrono));

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

    private void ouvrirPorte() {
        if (etat == EtatChambre.VERROUILLEE) {
            etat = EtatChambre.OUVERTE;
            Affichage.victoire("La porte principale de la cave s'ouvre dans un grincement strident !\n" +
                               "Vous vous enfuyez de la cave en courant !");
        }
    }

    public boolean estTerminee() {
        return etat == EtatChambre.OUVERTE;
    }
}