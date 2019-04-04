import javax.swing.JOptionPane;

public class Nebun {
	private String numeNebun;

	public Nebun(String name) {
		this.numeNebun = name;
	}

	public String getNumeNebun() {
		return numeNebun;
	}

	/**
	 * 
	 * @param tabla Tabla de sah, tinuta cum forma de matrice
	 * @param nebun Piesa nebun ce va fi mutata.
	 * @param linieInitial Linia initiala a piesei
	 * @param coloanaInitial Coloana initiala a piesei
	 * @param linieFinal Linia finala a piesei
	 * @param coloanaFinal Coloana finala a piesei
	 * @return 1 daca mutarea este valida, 0 daca este invalida
	 */
	public static int verificareMutare(TablaMeaDeSah tabla, Piesaa nebun, int linieInitial, int coloanaInitial,
			int linieFinal, int coloanaFinal) {
		int ok = 1;
		int culoarePiesa = 0;

		if (Util.verifyOutsideTable(linieInitial, coloanaInitial, linieFinal, coloanaFinal) == true)
			ok = 0;

		if (Math.abs(linieInitial - linieFinal) != Math.abs(coloanaInitial - coloanaFinal))
			ok = 0;

		if (linieFinal < linieInitial) {
			if (coloanaFinal < coloanaInitial) {
				int i = linieInitial - 1;
				int j = coloanaInitial - 1;
				while (i != linieFinal && j != coloanaFinal) {
					if (tabla.getTabla()[i][j].getNumePiesa().equals(" ") == false)
						ok = 0;
					i--;
					j--;
				}
				if (((nebun.getNumePiesa().equals("N") || nebun.getNumePiesa().equals("Q"))
						&& Util.verifyOpponentUppCase(tabla, linieFinal, coloanaFinal) == true)
						|| (((nebun.getNumePiesa().equals("n") || nebun.getNumePiesa().equals("q"))
								&& Util.verifyOpponentLowCase(tabla, linieFinal, coloanaFinal) == true)))
					ok = 0;
			}

			if (coloanaFinal > coloanaInitial) {
				int i = linieInitial - 1;
				int j = coloanaInitial + 1;
				while (i != linieFinal && j != coloanaFinal) {
					if (tabla.getTabla()[i][j].getNumePiesa().equals(" ") == false)
						ok = 0;
					i--;
					j++;
				}
				if (((nebun.getNumePiesa().equals("N") || nebun.getNumePiesa().equals("Q"))
						&& Util.verifyOpponentUppCase(tabla, linieFinal, coloanaFinal) == true)
						|| (((nebun.getNumePiesa().equals("n") || nebun.getNumePiesa().equals("q"))
								&& Util.verifyOpponentLowCase(tabla, linieFinal, coloanaFinal) == true)))
					ok = 0;
			}
		}

		if (linieFinal > linieInitial) {
			if (coloanaFinal < coloanaInitial) {
				int i = linieInitial + 1;
				int j = coloanaInitial - 1;
				while (i != linieFinal && j != coloanaFinal) {
					if (tabla.getTabla()[i][j].getNumePiesa().equals(" ") == false)
						ok = 0;
					i++;
					j--;
				}
				if (((nebun.getNumePiesa().equals("N") || nebun.getNumePiesa().equals("Q"))
						&& Util.verifyOpponentUppCase(tabla, linieFinal, coloanaFinal) == true)
						|| (((nebun.getNumePiesa().equals("n") || nebun.getNumePiesa().equals("q"))
								&& Util.verifyOpponentLowCase(tabla, linieFinal, coloanaFinal) == true)))
					ok = 0;
			}

			if (coloanaFinal > coloanaInitial) {
				int i = linieInitial + 1;
				int j = coloanaInitial + 1;
				while (i != linieFinal && j != coloanaFinal) {
					if (tabla.getTabla()[i][j].getNumePiesa().equals(" ") == false)
						ok = 0;
					i++;
					j++;
				}
				if (((nebun.getNumePiesa().equals("N") || nebun.getNumePiesa().equals("Q"))
						&& Util.verifyOpponentUppCase(tabla, linieFinal, coloanaFinal) == true)
						|| (((nebun.getNumePiesa().equals("n") || nebun.getNumePiesa().equals("q"))
								&& Util.verifyOpponentLowCase(tabla, linieFinal, coloanaFinal) == true)))
					ok = 0;
			}
		}

		Util.movePlayer(tabla, linieInitial, coloanaInitial, linieFinal, coloanaFinal, ok, nebun.getNumePiesa());

		return ok;

	}
}
