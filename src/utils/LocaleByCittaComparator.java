package utils;

import esterno.Locale;

public class LocaleByCittaComparator implements Comparator<Locale>{
	public int compare(Locale l1, Locale l2) {
		return l1.getCitta().compareTo(l2.getCitta());
	}

}
