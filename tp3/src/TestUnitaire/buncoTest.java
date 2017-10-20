package TestUnitaire;
import static org.junit.Assert.*;
import Specifique.BuncoJeu;

import org.junit.*;

public class buncoTest {
	private BuncoJeu jeu1;

	@Before
	public void faireAvant(){
		jeu1 = new BuncoJeu();
	}

	@Test
	public void strategieToNullTest(){
		jeu1.setRegleDeJeu(null);
		jeu1.calculerLeVainqueur();
		jeu1.calculeScoreTour();
	}

	@Test
	public void getCollectionJoueursNullTest(){
		assertTrue(jeu1.getJoueurs() != null);
	}

	@Test
	public void getCollectionDesNullTest(){
		assertTrue(jeu1.getDes() != null);
	}
}