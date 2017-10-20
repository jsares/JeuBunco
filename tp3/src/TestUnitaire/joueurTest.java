package TestUnitaire;
import static org.junit.Assert.*;
import Generique.Joueur;
import org.junit.*;

public class joueurTest {
	private Joueur joueur1;
	private Joueur joueur2;

	@Before
	public void faireAvant(){
		joueur1 = new Joueur();
		joueur2 = new Joueur();
	}

	@Test
	public void scoreSuperieurTest(){
		joueur1.setScore(10);
		joueur2.setScore(11);
		assertTrue(joueur1.compareTo(joueur2)==1);
	}

	@Test
	public void scoreInferieurTest(){
		joueur1.setScore(5);
		joueur2.setScore(11);
		assertTrue(joueur2.compareTo(joueur1)== -1 );
	}

	@Test
	public void memeScoreTest(){
		joueur1.setScore(11);
		joueur2.setScore(11);
		assertTrue(joueur2.compareTo(joueur1)== 0 );
	}

	@Test(expected=IllegalArgumentException.class)
	public void scoreNullTest(){
		joueur1.setScore(5);
		joueur1.compareTo(null);
	}
}
