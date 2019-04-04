import java.util.concurrent.ThreadLocalRandom;
/**
 * 
 * @author Maerchis
 * @param tabla reprezinta o matrice de elemente de tipul Piesaa
 * @param DIMENSIUNE_TABLA reprezinta numarul de linii si coloane ale tablei
 */
public class TablaMeaDeSah {
	
	private Piesaa[][] tabla;
	private static final int DIMENSIUNE_TABLA = 8;

	
	public TablaMeaDeSah() {
		tabla = new Piesaa[DIMENSIUNE_TABLA][DIMENSIUNE_TABLA];

		for (int i = 0; i < DIMENSIUNE_TABLA; i++)
			for (int j = 0; j < DIMENSIUNE_TABLA; j++)
				tabla[i][j] = new Piesaa();
	}

	public Piesaa[][] getTabla() {
		return tabla;
	}

	public static int getDimensiuneTabla() {
		return DIMENSIUNE_TABLA;
	}

	/**
	 * 
	 * @param tabla matricea de piese
	 * afiseaza tabla de sah pe ecran
	 */
	public static void afiseazaTabla(TablaMeaDeSah tabla) {
		int i = 0;
		int j = 0;

		System.out.println("  A B C D E F G H");

		for (i = 0; i < DIMENSIUNE_TABLA; i++) {
			for (j = 0; j < DIMENSIUNE_TABLA; j++) {
				if (i == 0 && j == 0)
					System.out.print("1 " + tabla.getTabla()[i][j].getNumePiesa() + " ");
				else if (i == 1 && j == 0)
					System.out.print("2 " + tabla.getTabla()[i][j].getNumePiesa() + " ");
				else if (i == 2 && j == 0)
					System.out.print("3 " + tabla.getTabla()[i][j].getNumePiesa() + " ");
				else if (i == 3 && j == 0)
					System.out.print("4 " + tabla.getTabla()[i][j].getNumePiesa() + " ");
				else if (i == 4 && j == 0)
					System.out.print("5 " + tabla.getTabla()[i][j].getNumePiesa() + " ");
				else if (i == 5 && j == 0)
					System.out.print("6 " + tabla.getTabla()[i][j].getNumePiesa() + " ");
				else if (i == 6 && j == 0)
					System.out.print("7 " + tabla.getTabla()[i][j].getNumePiesa() + " ");
				else if (i == 7 && j == 0)
					System.out.print("8 " + tabla.getTabla()[i][j].getNumePiesa() + " ");
				else
					System.out.print(tabla.getTabla()[i][j].getNumePiesa() + " ");
			}
			if (i == 0)
				System.out.print("1");
			if (i == 1)
				System.out.print("2");
			if (i == 2)
				System.out.print("3");
			if (i == 3)
				System.out.print("4");
			if (i == 4)
				System.out.print("5");
			if (i == 5)
				System.out.print("6");
			if (i == 6)
				System.out.print("7");
			if (i == 7)
				System.out.print("8");
			System.out.println();
		}
		System.out.print("  A B C D E F G H");
	}

	/**
	 * 
	 * @param tabla reprezinta tabla de sah, matricea de elemente de tip Piesaa
	 * @param piesa reprezinta un obiect de tipul piesa
	 * Metoda aseaza aleator pe tabla piesa, in primul loc random care nu este ocupat deja
	 */
	public static void aseazaPiesele(TablaMeaDeSah tabla, Piesaa piesa) {
		int ok = 0;
		while (ok == 0) {
			int i = ThreadLocalRandom.current().nextInt(0, 8);
			int j = ThreadLocalRandom.current().nextInt(0, 8);

			if (tabla.getTabla()[i][j].getNumePiesa().equals(" ")) {
				tabla.getTabla()[i][j].setNumePiesa(piesa.getNumePiesa());
				ok = 1;
			}
		}
	}

}
