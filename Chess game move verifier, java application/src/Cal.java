import javax.swing.JOptionPane;

public class Cal {
	private String numeCal;

	public Cal(String name) {
		this.numeCal = name;
	}

	public String getNumeCal() {
		return numeCal;
	}

	/**
	 * 
	 * @param tabla Tabla de sah, tinuta cum forma de matrice
	 * @param cal Piesa cal ce va fi mutata.
	 * @param linieInitial Linia initiala a piesei
	 * @param coloanaInitial Coloana initiala a piesei
	 * @param linieFinal Linia finala a piesei
	 * @param coloanaFinal Coloana finala a piesei
	 * @return 1 daca mutarea este valida, 0 daca este invalida
	 */
	public static int verificareMutare(TablaMeaDeSah tabla, Piesaa cal, int linieInitial, int coloanaInitial,
			int linieFinal, int coloanaFinal) {
		int ok = 0;

		int[] abscisa = { -1, 1, 2, 2, 1, -1, -2, -2 };
		int[] ordonata = { -2, -2, -1, 1, 2, 2, -1, 1 };
		int nrElementeAbscisaSiOrdonata = 8;

		for (int i = 0; i < nrElementeAbscisaSiOrdonata; i++)
			if (abscisa[i] == linieInitial - linieFinal && ordonata[i] == coloanaInitial - coloanaFinal)
				if ((cal.getNumePiesa().equals("C")
						&& Util.verifyOpponentLowCasePlusSpace(tabla, linieFinal, coloanaFinal) == true)
						|| (cal.getNumePiesa().equals("c")
								&& Util.verifyOpponentUppCasePlusSpace(tabla, linieFinal, coloanaFinal) == true))
					ok = 1;

		if (Util.verifyOutsideTable(linieInitial, coloanaInitial, linieFinal, coloanaFinal) == true)
			ok = 0;

		Util.movePlayer(tabla, linieInitial, coloanaInitial, linieFinal, coloanaFinal, ok, cal.getNumePiesa());

		return ok;
	}
}
