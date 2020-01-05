package utils;

import esterno.Fornitore;

public class FornitoreByNameComparator implements Comparator<Fornitore> {
	public int compare(Fornitore c1, Fornitore c2) {
		return c1.getNome().compareTo(c2.getNome());
	}
}