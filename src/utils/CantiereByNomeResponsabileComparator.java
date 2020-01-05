package utils;

import dirigenza.Cantiere;
import dipendenti.*;

public class CantiereByNomeResponsabileComparator implements Comparator<Cantiere> {
	public int compare(Cantiere o1, Cantiere o2) {
		Lavoratore l1 = (Lavoratore) o1.getResp();
		Lavoratore l2 = (Lavoratore) o2.getResp();
		if(!l1.getCognome().equals(l2.getCognome())) { //se i due cognomi NON sono uguali
			return l1.getCognome().compareTo(l2.getCognome());
		}
		else return l1.getNome().compareTo(l2.getNome());
	}
}
