package Specifique;

import Generique.Jeu;
import Generique.Joueur;

/*
 * Cette classe est le jeu bunco. Elle override creerPartie pour définir le flux de la partie.
 */
public class BuncoJeu extends Jeu {
	@Override
	public void creerPartie() {
		ajouterJoueur(2);
		ajouterDe(3);
		
		while (getNoManche() <= 6){
			for (Joueur joueur : getJoueurs()) {
				int points = 0;
				do {
					lancerDes();
					System.out.println(joueur.getNom() + " lance les dés et obtient " + calculeScoreTour() + " points.");
					points += calculeScoreTour();
				} while (!finDuTour());
				joueur.setScore(joueur.getScore() + points);		
				System.out.println(joueur.getNom() + " a " + points + " points Pour cette manche.");
			}
			System.out.println("Fin de la manche.\n");
			mancheSuivante();
		}
		Joueur gagnant = calculerLeVainqueur();
		System.out.println("\n==Bilan de la partie==");
		for (Joueur joueur : getJoueurs()) {
			System.out.println(joueur.getNom() + " a " + joueur.getScore() + " point au total");
		}
		if (gagnant != null) {
			System.out.println(gagnant.getNom() + " remporte la partie avec " + gagnant.getScore() + " point!");
		} else {
			
			System.out.println("Partie nulle!");
		}
	}

	protected boolean finDuTour() {
		return calculeScoreTour() == 21 || calculeScoreTour() == 0;		
	}
}
