package Specifique;

import Generique.De;
import Generique.Jeu;

/*
 * Ceci est une classe qui vérifie si la partie contient trois nombre pareil mais n'est pas un bunco.
 */
public class PointageIdentique extends Pointage {

	public PointageIdentique(){}
	
	public PointageIdentique(Pointage suivant) {
		super(suivant);
	}

	@Override
	protected int getPointage(Jeu jeu) {
		De last = jeu.getDes().last();
		for(De current : jeu.getDes()){
			if (current.compareTo(last) != 0){
				return 0;
			}
			last = current;
		}
		return 5;
	}

}
