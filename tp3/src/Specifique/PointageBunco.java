package Specifique;

import Generique.De;
import Generique.Jeu;

/*
 * Ceci est une classe qui vérifie si les trois dé sont pareil et il y a bunco.
 */
public class PointageBunco extends Pointage {

	public PointageBunco(){}
	
	public PointageBunco(Pointage suivant) {
		super(suivant);
	}

	@Override
	protected int getPointage(Jeu jeu) {
		De last = jeu.getDes().last();
		for(De current : jeu.getDes()){
			if (current.compareTo(last) != 0 || current.getFaceObtenue() != jeu.getNoManche()){
				return 0;
			}
			last = current;
		}
		return 21;
	}

}
