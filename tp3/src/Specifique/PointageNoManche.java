package Specifique;

import Generique.De;
import Generique.Jeu;

/*
 * Ceci est une classe qui vérifie le nombre de dé egal au numéro de la manche.
 */
public class PointageNoManche extends Pointage {

	public PointageNoManche(){}
	
	public PointageNoManche(Pointage suivant) {
		super(suivant);
	}

	@Override
	protected int getPointage(Jeu jeu) {
		int nbPoint=0;

		for(De current : jeu.getDes()){
			if (current.getFaceObtenue() == jeu.getNoManche()){
				nbPoint++;
			}
			
		}
		return nbPoint;
	}
}