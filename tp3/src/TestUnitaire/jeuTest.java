package TestUnitaire;
import static org.junit.Assert.assertTrue;
import Generique.Jeu;

import org.junit.*;

public class jeuTest {
		private Jeu jeu1;
		
		@Before
		public void faireAvant(){
			jeu1 = new Jeu() {
				
				@Override
				public void creerPartie() {
					
					
				}
			};
		}

		@Test
		public void regleDeJeuToNullTest(){
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

