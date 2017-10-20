package Specifique;

import Generique.Jeu;

/*
 * Ceci est une classe abstraite qui s'occupe de claculer les pointage selon des règle classé en ordre de priorité.
 */
abstract public class Pointage {
	private Pointage suivant = null;
	
	public Pointage(){}
	
	public Pointage(Pointage suivant) {
		this.suivant = suivant;
	}
	
	public int calculerPointage(Jeu jeu) {
		int pointage = getPointage(jeu);
		
		if (pointage == 0) {
			return suivant != null ? suivant.calculerPointage(jeu) : 0;
		} else {
			return pointage;
		}
	}
	
	protected abstract int getPointage(Jeu jeu);
}
