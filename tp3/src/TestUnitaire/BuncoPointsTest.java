package TestUnitaire;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Generique.De;
import Specifique.BuncoJeu;
import Specifique.BuncoPoints;

public class BuncoPointsTest {
	private BuncoPoints points;
	private BuncoJeu jeu;
	private De de1 = new De();
	private De de2 = new De();
	private De de3 = new De();

	@Before
	public void faireAvant(){
		points = new BuncoPoints();
		jeu = new BuncoJeu();
		jeu.setRegleDeJeu(points);
		jeu.getDes().insert(de1);
		jeu.getDes().insert(de2);
		jeu.getDes().insert(de3);
	}

	@Test
	public void pointageBunco(){
		de1.setFaceObtenue(1);
		de2.setFaceObtenue(1);
		de3.setFaceObtenue(1);
		assertTrue(jeu.calculeScoreTour() == 21);
	}

	@Test
	public void pointageIdentique(){
		de1.setFaceObtenue(3);
		de2.setFaceObtenue(3);
		de3.setFaceObtenue(3);
		assertTrue(jeu.calculeScoreTour() == 5);
	}

	@Test
	public void pointageNombre1(){
		de1.setFaceObtenue(1);
		de2.setFaceObtenue(5);
		de3.setFaceObtenue(6);
		assertTrue(jeu.calculeScoreTour() == 1);
	}

	@Test
	public void pointageNombre2(){
		de1.setFaceObtenue(1);
		de2.setFaceObtenue(1);
		de3.setFaceObtenue(3);
		assertTrue(jeu.calculeScoreTour() == 2);
	}

	@Test
	public void pointageZero(){
		de1.setFaceObtenue(4);
		de2.setFaceObtenue(5);
		de3.setFaceObtenue(6);
		assertTrue(jeu.calculeScoreTour() == 0);
	}
}