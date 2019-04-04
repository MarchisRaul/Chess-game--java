import javax.swing.JOptionPane;

public class Pionn {
	private String numePion;

	public Pionn(String name) {
		this.numePion = name;
	}

	public String getNumePion() {
		return numePion;
	}
	/**
	 * 
	 * @param tabla Tabla de sah, tinuta cum forma de matrice
	 * @param pion Piesa pion ce va fi mutata.
	 * @param linieInitial Linia initiala a piesei
	 * @param coloanaInitial Coloana initiala a piesei
	 * @param linieFinal Linia finala a piesei
	 * @param coloanaFinal Coloana finala a piesei
	 * @return 1 daca mutarea este valida, 0 daca este invalida
	 */
	public static int verificareMutare(TablaMeaDeSah tabla, Piesaa pion, int linieInitial, int coloanaInitial,
			int linieFinal, int coloanaFinal) {
		int ok = 1;

		if (Util.verifyOutsideTable(linieInitial, coloanaInitial, linieFinal, coloanaFinal) == true)
			ok = 0;

		if ((linieFinal - linieInitial != 1 && pion.getNumePiesa().equals("p"))
				|| (linieFinal - linieInitial != -1 && pion.getNumePiesa().equals("P")))
			ok = 0;

		if (coloanaFinal == coloanaInitial - 1 || coloanaFinal == coloanaInitial + 1) {
			if ((pion.getNumePiesa().equals("P")
					&& Util.verifyOpponentUppCasePlusSpace(tabla, linieFinal, coloanaFinal) == true)
					|| ((pion.getNumePiesa().equals("p")
							&& Util.verifyOpponentLowCasePlusSpace(tabla, linieFinal, coloanaFinal) == true)))
				ok = 0;
		}

		if ((linieFinal - linieInitial == 1) && (coloanaInitial == coloanaFinal))
			if (tabla.getTabla()[linieFinal][coloanaFinal].getNumePiesa().equals(" ") == false)
				ok = 0;

		Util.movePlayer(tabla, linieInitial, coloanaInitial, linieFinal, coloanaFinal, ok, pion.getNumePiesa());

		return ok;

	}
}
