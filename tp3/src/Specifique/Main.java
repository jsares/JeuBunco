package Specifique;

/*
 * Ceci est la classe main. Elle initialise un jeu bunco et l'utilise.
 */
public class Main {

	public static void main(String[] args) {
		BuncoJeu jeu = new BuncoJeu();
		jeu.setRegleDeJeu(new BuncoPoints());
		jeu.creerPartie();
	}

}
