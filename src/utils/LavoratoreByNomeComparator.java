package utils;
import dipendenti.Lavoratore;

public class LavoratoreByNomeComparator implements Comparator<Lavoratore> {
	public int compare(Lavoratore l1, Lavoratore l2) {
		if(!l1.getCognome().equals(l2.getCognome())) { //se i due cognomi NON sono uguali
			return l1.getCognome().compareTo(l2.getCognome());
		}
		else return l1.getNome().compareTo(l2.getNome());
	}
}
