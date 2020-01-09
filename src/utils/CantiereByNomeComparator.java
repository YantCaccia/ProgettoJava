package utils;

import dirigenza.Cantiere;

public class CantiereByNomeComparator implements Comparator<Cantiere> {
	public int compare(Cantiere o1, Cantiere o2) {
		return o1.getNome().compareTo(o2.getNome());
	}
}
