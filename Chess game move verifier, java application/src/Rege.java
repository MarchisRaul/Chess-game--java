import javax.swing.JOptionPane;

public class Rege {
	private String numeRege;

	public Rege(String name) {
		this.numeRege = name;
	}

	public String getNumeRege() {
		return numeRege;
	}
	/**
	 * 
	 * @param tabla Tabla de sah, tinuta cum forma de matrice
	 * @param rege Piesa rege ce va fi mutata.
	 * @param linieInitial Linia initiala a piesei
	 * @param coloanaInitial Coloana initiala a piesei
	 * @param linieFinal Linia finala a piesei
	 * @param coloanaFinal Coloana finala a piesei
	 * @return 1 daca mutarea este valida, 0 daca este invalida
	 */
	public static int verificareMutare(TablaMeaDeSah tabla, Piesaa rege, int linieInitial, int coloanaInitial,
			int linieFinal, int coloanaFinal) {
		int ok = 0;

		int[] abscisa = { 0, 1, 1, 1, 0, -1, -1, -1 };
		int[] ordonata = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int nrElementeAbscisaSiOrdonata = 8;

		for (int i = 0; i < nrElementeAbscisaSiOrdonata; i++)
			if (abscisa[i] == linieInitial - linieFinal && ordonata[i] == coloanaInitial - coloanaFinal)
				if ((rege.getNumePiesa().equals("K")
						&& Util.verifyOpponentLowCasePlusSpace(tabla, linieFinal, coloanaFinal) == true)
						|| (rege.getNumePiesa().equals("k")
								&& Util.verifyOpponentUppCasePlusSpace(tabla, linieFinal, coloanaFinal) == true))
					ok = 1;

		if (Util.verifyOutsideTable(linieInitial, coloanaInitial, linieFinal, coloanaFinal) == true)
			ok = 0;

		Util.movePlayer(tabla, linieInitial, coloanaInitial, linieFinal, coloanaFinal, ok, rege.getNumePiesa());

		return ok;
	}

}
