package src;
import java.util.ArrayList;


/**
 * Représente le Cinéma, premier niveau du jeu.
 * Le joueur doit résoudre 3 énigmes pour pouvoir sortir du cinéma.
 *
 * @author Fanny Bouffard
 */
public class Cinema extends Piece implements Jouable {


    private final Chronometre chrono;
    private EtatChambre etat = EtatChambre.VERROUILLEE;


    public Cinema(Chronometre chrono) {
        super("Cinema", 1);
        this.chrono = chrono;
    }


    @Override
    public void afficherDescription() {
        Affichage.titre("NIVEAU 1 : LA DERNIERE SEANCE");


        System.out.println("Vous entrez dans un cinéma pour assister à une séance.");
        System.out.println("Les lumières s'éteignent...");
        System.out.println("Soudain, les portes se verrouillent derrière vous.");
        System.out.println("Un message apparaît sur l'écran.");
        System.out.println("Vous devez résoudre 3 énigmes pour sortir.");
        System.out.println("Le chronomètre commence !");
        Affichage.separation();
    }


    @Override
    public void jouerNiveau() {


        if (estTerminee()) {
            System.out.println("Le cinéma est déjà terminé !");
            return;
        }


        afficherDescription();


        ArrayList<Enigme> enigmes = new ArrayList<>();


        enigmes.add(new EnigmeTicket(chrono));
        enigmes.add(new EnigmeProjecteur(chrono));
        enigmes.add(new EnigmeNeTeRetournePas(chrono));


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


            Affichage.victoire(
                "Vous avez réussi à sortir du cinéma !\n"
                + "Vous pouvez maintenant passer à la salle suivante."
            );
        }
    }


    public boolean estTerminee() {
        return etat == EtatChambre.OUVERTE;
    }
}
