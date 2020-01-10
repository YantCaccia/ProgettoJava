package utils;

import esterno.Fornitore;

public class FornitoreByProdottoComparator implements Comparator<Fornitore>{

	@Override
	public int compare(Fornitore c1, Fornitore c2) {
		return c1.getProdottoFornito().toString().compareTo(c2.getProdottoFornito().toString());
	}

}
