package Generique;

/*
 * Ceci est un joueur de notre jeu. Contient son score
 */
public class Joueur implements Comparable<Joueur> {
	private String nom = "";
	private int score = 0;
	
	@Override
	public int compareTo(Joueur joueur) {
		if(joueur == null){
			throw new IllegalArgumentException();
		}
		return score < joueur.score ? 1 : score > joueur.score ? -1 : 0;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
