package Specifique;

import Generique.Jeu;
import Generique.Joueur;
import Generique.RegleDeJeu;

/*
 * Cette classe implémente les règlements de bunco.
 */
public class BuncoPoints implements RegleDeJeu{
	private Pointage pointage;
	
	public BuncoPoints() {
		pointage = new PointageBunco(new PointageIdentique(new PointageNoManche()));
	}
	
	@Override
	public Joueur calculerLeVainqueur(Jeu jeu) {
		
		Joueur last = jeu.getJoueurs().last();
		Joueur gagnant = null;
		for(Joueur current : jeu.getJoueurs()) {
			gagnant = current.compareTo(last) == 1 ? last : current.compareTo(last) == -1 ? gagnant : null;
			last = current;
		}
		return gagnant;
	}

	@Override
	public int calculerScoreTour(Jeu jeu) {
		return pointage.calculerPointage(jeu);
	}

}
