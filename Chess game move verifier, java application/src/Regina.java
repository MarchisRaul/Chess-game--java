import javax.swing.JOptionPane;

public class Regina {
	private String numeRegina;

	public Regina(String name) {
		this.numeRegina = name;
	}

	public String getNumeRegina() {
		return numeRegina;
	}
	/**
	 * 
	 * @param tabla Tabla de sah, tinuta cum forma de matrice
	 * @param regina Piesa regina ce va fi mutata.
	 * @param linieInitial Linia initiala a piesei
	 * @param coloanaInitial Coloana initiala a piesei
	 * @param linieFinal Linia finala a piesei
	 * @param coloanaFinal Coloana finala a piesei
	 * @return 1 daca mutarea este valida, 0 daca este invalida
	 */
	public static int verificareMutare(TablaMeaDeSah tabla, Piesaa regina, int linieInitial, int coloanaInitial,
			int linieFinal, int coloanaFinal) {
		int ok = 0;

		ok = Nebun.verificareMutare(tabla, regina, linieInitial, coloanaInitial, linieFinal, coloanaFinal);
		if (ok == 1)
			return ok;

		ok = Tura.verificareMutare(tabla, regina, linieInitial, coloanaInitial, linieFinal, coloanaFinal);
		if (ok == 1)
			return ok;

		return 0;

	}
}
