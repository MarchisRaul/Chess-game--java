import javax.swing.JOptionPane;

public class Tura {
	private String numeTura;

	public Tura(String name) {
		this.numeTura = name;
	}

	public String getNumeTura() {
		return numeTura;
	}
	/**
	 * 
	 * @param tabla Tabla de sah, tinuta cum forma de matrice
	 * @param cal Piesa tura ce va fi mutata.
	 * @param linieInitial Linia initiala a piesei
	 * @param coloanaInitial Coloana initiala a piesei
	 * @param linieFinal Linia finala a piesei
	 * @param coloanaFinal Coloana finala a piesei
	 * @return 1 daca mutarea este valida, 0 daca este invalida
	 */
	public static int verificareMutare(TablaMeaDeSah tabla, Piesaa tura, int linieInitial, int coloanaInitial,
			int linieFinal, int coloanaFinal) {
		int ok = 1;

		if (Util.verifyOutsideTable(linieInitial, coloanaInitial, linieFinal, coloanaFinal) == true)
			ok = 0;

		if (coloanaInitial == coloanaFinal) {
			if (linieFinal < linieInitial) {
				for (int i = linieInitial - 1; i > linieFinal; i--)
					if (tabla.getTabla()[i][coloanaInitial].getNumePiesa().equals(" ") == false)
						ok = 0;
				if (((tura.getNumePiesa().equals("T") || tura.getNumePiesa().equals("Q"))
						&& Util.verifyOpponentUppCase(tabla, linieFinal, coloanaFinal) == true)
						|| (((tura.getNumePiesa().equals("t") || tura.getNumePiesa().equals("q"))
								&& Util.verifyOpponentLowCase(tabla, linieFinal, coloanaFinal) == true)))
					ok = 0;
			}
			if (linieFinal > linieInitial) {
				for (int i = linieInitial + 1; i < linieFinal; i++)
					if (tabla.getTabla()[i][coloanaInitial].getNumePiesa().equals(" ") == false)
						ok = 0;
				if (((tura.getNumePiesa().equals("T") || tura.getNumePiesa().equals("Q"))
						&& Util.verifyOpponentUppCase(tabla, linieFinal, coloanaFinal) == true)
						|| (((tura.getNumePiesa().equals("t") || tura.getNumePiesa().equals("q"))
								&& Util.verifyOpponentLowCase(tabla, linieFinal, coloanaFinal) == true)))
					ok = 0;
			}
		}

		if (linieInitial == linieFinal) {
			if (coloanaFinal < coloanaInitial) {
				for (int i = coloanaInitial - 1; i > coloanaFinal; i--)
					if (tabla.getTabla()[linieInitial][i].getNumePiesa().equals(" ") == false)
						ok = 0;
				if (((tura.getNumePiesa().equals("T") || tura.getNumePiesa().equals("Q"))
						&& Util.verifyOpponentUppCase(tabla, linieFinal, coloanaFinal) == true)
						|| (((tura.getNumePiesa().equals("t") || tura.getNumePiesa().equals("q"))
								&& Util.verifyOpponentLowCase(tabla, linieFinal, coloanaFinal) == true)))
					ok = 0;
			}

			if (coloanaFinal > coloanaInitial) {
				for (int i = coloanaInitial + 1; i < coloanaFinal; i++)
					if (tabla.getTabla()[linieInitial][i].getNumePiesa().equals(" ") == false)
						ok = 0;
				if (((tura.getNumePiesa().equals("T") || tura.getNumePiesa().equals("Q"))
						&& Util.verifyOpponentUppCase(tabla, linieFinal, coloanaFinal) == true)
						|| (((tura.getNumePiesa().equals("t") || tura.getNumePiesa().equals("q"))
								&& Util.verifyOpponentLowCase(tabla, linieFinal, coloanaFinal) == true)))
					ok = 0;
			}
		}
		if (linieInitial != linieFinal && coloanaInitial != coloanaFinal)
			ok = 0;

		Util.movePlayer(tabla, linieInitial, coloanaInitial, linieFinal, coloanaFinal, ok, tura.getNumePiesa());

		return ok;

	}

}
