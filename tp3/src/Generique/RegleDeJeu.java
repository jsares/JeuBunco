package Generique;

/*
 * Cette interface représente une classe qui implémente les règles d'un jeu.
 * Les règles calcule le score du tour et le vainqueur
 */
public interface RegleDeJeu {
	
	public Joueur calculerLeVainqueur(Jeu jeu);
	public int calculerScoreTour(Jeu jeu);

}
