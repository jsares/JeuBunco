package Generique;

import java.util.Random;

/*
 * Ceci est une classe representant un de. Contient sa face actuelle.
 */
public class De implements Comparable<De> {

	int faceObtenue = 0;
	final static int MIN = 1;
	final static int MAX = 6;


	@Override
	public int compareTo(De de) {
		if(de == null){
			throw new IllegalArgumentException();
		}
		return faceObtenue < de.faceObtenue ? 1 : faceObtenue > de.faceObtenue ? -1 : 0;
	}

	public int getFaceObtenue() {
		return faceObtenue;
	}

	public void setFaceObtenue(int faceObtenue) {
		this.faceObtenue = faceObtenue;
	}

	public void lancer(){

		Random rand = new Random();

		setFaceObtenue(rand.nextInt((MAX-MIN) +1)+MIN);
	}

}
