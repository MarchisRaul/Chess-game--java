import javax.swing.JOptionPane;

public class Util {
	/**
	 * 
	 * @param tabla matricea de piese
	 * @param linieFinal linia unde vrem sa mutam piesa
	 * @param coloanaFinal coloana unde vrem sa mutam piesa
	 * @return true daca spatiul unde mutam e gol sau o piesa "litera mica" (neagra)
	 */
	public static boolean verifyOpponentLowCasePlusSpace(TablaMeaDeSah tabla, int linieFinal, int coloanaFinal) {
		if (tabla.getTabla()[linieFinal][coloanaFinal].getNumePiesa().equals(" ")
				|| tabla.getTabla()[linieFinal][coloanaFinal].getNumePiesa().equals("p")
				|| tabla.getTabla()[linieFinal][coloanaFinal].getNumePiesa().equals("t")
				|| tabla.getTabla()[linieFinal][coloanaFinal].getNumePiesa().equals("c")
				|| tabla.getTabla()[linieFinal][coloanaFinal].getNumePiesa().equals("n")
				|| tabla.getTabla()[linieFinal][coloanaFinal].getNumePiesa().equals("q")
				|| tabla.getTabla()[linieFinal][coloanaFinal].getNumePiesa().equals("k"))
			return true;
		return false;
	}
	
	/**
	 * 
	 * @param tabla matricea de piese
	 * @param linieFinal linia unde vrem sa mutam piesa
	 * @param coloanaFinal coloana unde vrem sa mutam piesa
	 * @return true daca spatiul unde mutam e gol sau o piesa "litera mare" (alba)
	 */
	public static boolean verifyOpponentUppCasePlusSpace(TablaMeaDeSah tabla, int linieFinal, int coloanaFinal) {
		if (tabla.getTabla()[linieFinal][coloanaFinal].getNumePiesa().equals(" ")
				|| tabla.getTabla()[linieFinal][coloanaFinal].getNumePiesa().equals("P")
				|| tabla.getTabla()[linieFinal][coloanaFinal].getNumePiesa().equals("T")
				|| tabla.getTabla()[linieFinal][coloanaFinal].getNumePiesa().equals("C")
				|| tabla.getTabla()[linieFinal][coloanaFinal].getNumePiesa().equals("N")
				|| tabla.getTabla()[linieFinal][coloanaFinal].getNumePiesa().equals("Q")
				|| tabla.getTabla()[linieFinal][coloanaFinal].getNumePiesa().equals("K"))
			return true;
		return false;
	}
	
	/**
	 * 
	 * @param tabla matricea de piese
	 * @param linieFinal linia unde vrem sa mutam piesa
	 * @param coloanaFinal coloana unde vrem sa mutam piesa
	 * @return true daca spatiul unde mutam o piesa "litera mica" (neagra)
	 */
	public static boolean verifyOpponentLowCase(TablaMeaDeSah tabla, int linieFinal, int coloanaFinal) {
		if (tabla.getTabla()[linieFinal][coloanaFinal].getNumePiesa().equals("p")
				|| tabla.getTabla()[linieFinal][coloanaFinal].getNumePiesa().equals("t")
				|| tabla.getTabla()[linieFinal][coloanaFinal].getNumePiesa().equals("c")
				|| tabla.getTabla()[linieFinal][coloanaFinal].getNumePiesa().equals("n")
				|| tabla.getTabla()[linieFinal][coloanaFinal].getNumePiesa().equals("q")
				|| tabla.getTabla()[linieFinal][coloanaFinal].getNumePiesa().equals("k"))
			return true;
		return false;
	}
	/**
	 * 
	 * @param tabla matricea de piese
	 * @param linieFinal linia unde vrem sa mutam piesa
	 * @param coloanaFinal coloana unde vrem sa mutam piesa
	 * @return true daca spatiul unde mutam o piesa "litera mare" (alba)
	 */
	public static boolean verifyOpponentUppCase(TablaMeaDeSah tabla, int linieFinal, int coloanaFinal) {
		if (tabla.getTabla()[linieFinal][coloanaFinal].getNumePiesa().equals("P")
				|| tabla.getTabla()[linieFinal][coloanaFinal].getNumePiesa().equals("T")
				|| tabla.getTabla()[linieFinal][coloanaFinal].getNumePiesa().equals("C")
				|| tabla.getTabla()[linieFinal][coloanaFinal].getNumePiesa().equals("N")
				|| tabla.getTabla()[linieFinal][coloanaFinal].getNumePiesa().equals("Q")
				|| tabla.getTabla()[linieFinal][coloanaFinal].getNumePiesa().equals("K"))
			return true;
		return false;
	}
	
	/**
	 * 
	 * @param linieInitial linia unde se afla piesa
	 * @param coloanaInitial coloana unde se afla piesa
	 * @param linieFinal linia unde vrem sa mutam
	 * @param coloanaFinal coloana unde vrem sa mutam
	 * @return true daca pozitia initiala / pozitia finala a piesei iese din tabla de sah
	 */
	public static boolean verifyOutsideTable(int linieInitial, int coloanaInitial, int linieFinal, int coloanaFinal) {
		if (linieInitial < 0 || linieInitial > 7 || coloanaInitial < 0 || coloanaInitial > 7 || linieFinal < 0
				|| linieFinal > 7 || coloanaFinal < 0 || coloanaFinal > 7
				|| (linieInitial == linieFinal && coloanaInitial == coloanaFinal))
			return true;
		return false;
	}
	
	/**
	 * 
	 * @param tabla matricea de piese
	 * @param linieInitial linia unde se afla piesa
	 * @param coloanaInitial coloana unde se afla piesa
	 * @param linieFinal linia unde vrem sa mutam
	 * @param coloanaFinal coloana unde vrem sa mutam
	 * @param ok daca e 1, se muta piesa respectiva si se afiseaza tabla
	 * @param numePiesa tipul piesei
	 */
	public static void movePlayer(TablaMeaDeSah tabla, int linieInitial, int coloanaInitial, int linieFinal,
			int coloanaFinal, int ok, String numePiesa) {
		if (ok == 1) {
			tabla.getTabla()[linieInitial][coloanaInitial].setNumePiesa(" ");
			tabla.getTabla()[linieFinal][coloanaFinal].setNumePiesa(numePiesa);
			System.out.println();
			System.out.println();
			JOptionPane.showMessageDialog(null, "Tabla a fost modificata cu succes !");
			TablaMeaDeSah.afiseazaTabla(tabla);
		}
	}
}
