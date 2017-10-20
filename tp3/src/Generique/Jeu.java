package Generique;

/*
 * Ceci est une classe abstrate qui sert de base pour implémenter un jeu.
 * Elle contient plein de méthodes servant a controller le flux d'un jeu.
 * creerPartie sera définie avec l'implémentation d'un jeu
 */
public abstract class Jeu {
	private int noManche = 1;
	private RegleDeJeu regleDeJeu = null;
	private Collection<Joueur> joueurs;
	private Collection<De> des;
	
	public Jeu () {
		effacer();
	}
	
	public int getNoManche() {
		return noManche;
	}

	public int calculeScoreTour() {
		return regleDeJeu != null ? regleDeJeu.calculerScoreTour(this) : 0;
	}
	
	public Joueur calculerLeVainqueur() {
		return regleDeJeu != null ? regleDeJeu.calculerLeVainqueur(this) : null;
	}
	
	public abstract void creerPartie();
	
	public RegleDeJeu getRegleDeJeu() {
		return regleDeJeu;
	}
	
	public void setRegleDeJeu(RegleDeJeu regleDeJeu) {
		this.regleDeJeu = regleDeJeu;
	}
	
	protected final void ajouterJoueur() {
		Joueur joueur = new Joueur();
		joueurs.insert(joueur);
		joueur.setNom("Joueur " + joueurs.count());
	}
	
	protected final void ajouterJoueur(int nombre) {
		for (int i = 0 ; i<nombre ; i++) {
			ajouterJoueur();
		}
	}
	
	protected final void ajouterDe() {
		De de = new De();
		de.lancer();
		des.insert(de);
	}
	
	protected final void ajouterDe(int nombre) {
		for (int i = 0 ; i<nombre ; i++) {
			ajouterDe();
		}
	}
	
	protected final void lancerDes() {
		for (De de : des) {
			de.lancer();
		}
	}
	
	protected final void mancheSuivante() {
		noManche++;
	}
	
	public Collection<De> getDes() {
		return des;
	}
	
	public Collection<Joueur> getJoueurs () {
		return joueurs;
	}
	
	public void effacer() {
		joueurs = new Collection<Joueur>();
		des = new Collection<De>();
		noManche = 1;
	}
}
