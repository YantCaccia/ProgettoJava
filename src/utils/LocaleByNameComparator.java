package utils;

import esterno.Locale;

public class LocaleByNameComparator implements Comparator<Locale> {
	public int compare(Locale c1, Locale c2) {
		return c1.getNome().compareTo(c2.getNome());
	}
}