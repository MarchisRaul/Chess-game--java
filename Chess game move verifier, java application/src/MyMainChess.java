import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JOptionPane;

public class MyMainChess {

	public static void main(String[] args) {
		TablaMeaDeSah tabla = new TablaMeaDeSah();

		for (int i = 0; i < TablaMeaDeSah.getDimensiuneTabla(); i++)
			for (int j = 0; j < TablaMeaDeSah.getDimensiuneTabla(); j++)
				tabla.getTabla()[i][j].setNumePiesa(" ");

		Pionn pAlb = new Pionn("P");
		Cal cAlb = new Cal("C");
		Nebun nAlb = new Nebun("N");
		Tura tAlb = new Tura("T");
		Regina qAlb = new Regina("Q");
		Rege kAlb = new Rege("K");

		Pionn pNegru = new Pionn("p");
		Cal cNegru = new Cal("c");
		Nebun nNegru = new Nebun("n");
		Tura tNegru = new Tura("t");
		Regina qNegru = new Regina("q");
		Rege kNegru = new Rege("k");

		Piesaa pionAlb = new Piesaa(pAlb.getNumePion());
		pionAlb.setNumePiesa("P");
		Piesaa turaAlb = new Piesaa(tAlb.getNumeTura());
		turaAlb.setNumePiesa("T");
		Piesaa calAlb = new Piesaa(cAlb.getNumeCal());
		calAlb.setNumePiesa("C");
		Piesaa nebunAlb = new Piesaa(nAlb.getNumeNebun());
		nebunAlb.setNumePiesa("N");
		Piesaa reginaAlb = new Piesaa(qAlb.getNumeRegina());
		reginaAlb.setNumePiesa("Q");
		Piesaa regeAlb = new Piesaa(kAlb.getNumeRege());
		regeAlb.setNumePiesa("K");

		for (int i = 0; i < 8; i++)
			TablaMeaDeSah.aseazaPiesele(tabla, pionAlb);
		for (int i = 0; i < 2; i++) {
			TablaMeaDeSah.aseazaPiesele(tabla, turaAlb);
			TablaMeaDeSah.aseazaPiesele(tabla, calAlb);
			TablaMeaDeSah.aseazaPiesele(tabla, nebunAlb);
		}
		TablaMeaDeSah.aseazaPiesele(tabla, regeAlb);
		TablaMeaDeSah.aseazaPiesele(tabla, reginaAlb);

		Piesaa pionNegru = new Piesaa(pNegru.getNumePion());
		pionNegru.setNumePiesa("p");
		Piesaa turaNegru = new Piesaa(tNegru.getNumeTura());
		turaNegru.setNumePiesa("t");
		Piesaa calNegru = new Piesaa(cNegru.getNumeCal());
		calNegru.setNumePiesa("c");
		Piesaa nebunNegru = new Piesaa(nNegru.getNumeNebun());
		nebunNegru.setNumePiesa("n");
		Piesaa reginaNegru = new Piesaa(qNegru.getNumeRegina());
		reginaNegru.setNumePiesa("q");
		Piesaa regeNegru = new Piesaa(kNegru.getNumeRege());
		regeNegru.setNumePiesa("k");

		for (int i = 0; i < 8; i++)
			TablaMeaDeSah.aseazaPiesele(tabla, pionNegru);
		for (int i = 0; i < 2; i++) {
			TablaMeaDeSah.aseazaPiesele(tabla, turaNegru);
			TablaMeaDeSah.aseazaPiesele(tabla, calNegru);
			TablaMeaDeSah.aseazaPiesele(tabla, nebunNegru);
		}
		TablaMeaDeSah.aseazaPiesele(tabla, regeNegru);
		TablaMeaDeSah.aseazaPiesele(tabla, reginaNegru);

		System.out.println("P / p" + " - pioni");
		System.out.println("T / t" + " - ture");
		System.out.println("C / c" + " - cai");
		System.out.println("N / n" + " - nebuni");
		System.out.println("Q / q" + " - regine");
		System.out.println("K / k" + " - regi");
		System.out.println();
		TablaMeaDeSah.afiseazaTabla(tabla);
		System.out.println();

		int ok = 1;
		int valid = 0;
		int a = 0;
		int b = 0;
		int m = 0;
		int n = 0;
		String aux = JOptionPane.showInputDialog(null, "Introduceti linia initiala: ");
		a = Integer.parseInt(aux) - 1;
		aux = JOptionPane.showInputDialog(null, "Introduceti coloana initiala: ");
		switch (aux) {
		case "A":
			b = 0;
			break;
		case "B":
			b = 1;
			break;
		case "C":
			b = 2;
			break;
		case "D":
			b = 3;
			break;
		case "E":
			b = 4;
			break;
		case "F":
			b = 5;
			break;
		case "G":
			b = 6;
			break;
		case "H":
			b = 7;
			break;
		default:
			JOptionPane.showMessageDialog(null, "Coloana invalida !");
			ok = 0;
			break;
		}

		aux = JOptionPane.showInputDialog(null, "Introduceti linia finala: ");
		m = Integer.parseInt(aux) - 1;
		aux = JOptionPane.showInputDialog(null, "Introduceti coloana finala: ");
		switch (aux) {
		case "A":
			n = 0;
			break;
		case "B":
			n = 1;
			break;
		case "C":
			n = 2;
			break;
		case "D":
			n = 3;
			break;
		case "E":
			n = 4;
			break;
		case "F":
			n = 5;
			break;
		case "G":
			n = 6;
			break;
		case "H":
			n = 7;
			break;
		default:
			JOptionPane.showMessageDialog(null, "Coloana invalida !");
			ok = 0;
			break;
		}

		if (ok == 1 && tabla.getTabla()[a][b].getNumePiesa().equals("p"))
			valid = Pionn.verificareMutare(tabla, tabla.getTabla()[a][b], a, b, m, n);
		else if (ok == 1 && tabla.getTabla()[a][b].getNumePiesa().equals("P"))
			valid = Pionn.verificareMutare(tabla, tabla.getTabla()[a][b], a, b, m, n);
		else if (ok == 1 && tabla.getTabla()[a][b].getNumePiesa().equals("c"))
			valid = Cal.verificareMutare(tabla, tabla.getTabla()[a][b], a, b, m, n);
		else if (ok == 1 && tabla.getTabla()[a][b].getNumePiesa().equals("C"))
			valid = Cal.verificareMutare(tabla, tabla.getTabla()[a][b], a, b, m, n);
		else if (ok == 1 && tabla.getTabla()[a][b].getNumePiesa().equals("T"))
			valid = Tura.verificareMutare(tabla, tabla.getTabla()[a][b], a, b, m, n);
		else if (ok == 1 && tabla.getTabla()[a][b].getNumePiesa().equals("t"))
			valid = Tura.verificareMutare(tabla, tabla.getTabla()[a][b], a, b, m, n);
		else if (ok == 1 && tabla.getTabla()[a][b].getNumePiesa().equals("N"))
			valid = Nebun.verificareMutare(tabla, tabla.getTabla()[a][b], a, b, m, n);
		else if (ok == 1 && tabla.getTabla()[a][b].getNumePiesa().equals("n"))
			valid = Nebun.verificareMutare(tabla, tabla.getTabla()[a][b], a, b, m, n);
		else if (ok == 1 && tabla.getTabla()[a][b].getNumePiesa().equals("Q"))
			valid = Regina.verificareMutare(tabla, tabla.getTabla()[a][b], a, b, m, n);
		else if (ok == 1 && tabla.getTabla()[a][b].getNumePiesa().equals("q"))
			valid = Regina.verificareMutare(tabla, tabla.getTabla()[a][b], a, b, m, n);
		else if (ok == 1 && tabla.getTabla()[a][b].getNumePiesa().equals("K"))
			valid = Rege.verificareMutare(tabla, tabla.getTabla()[a][b], a, b, m, n);
		else if (ok == 1 && tabla.getTabla()[a][b].getNumePiesa().equals("k"))
			valid = Rege.verificareMutare(tabla, tabla.getTabla()[a][b], a, b, m, n);

		if (valid == 1)
			JOptionPane.showMessageDialog(null, "Mutare valida !");
		else
			JOptionPane.showMessageDialog(null, "Mutare invalida !");

	}
}
