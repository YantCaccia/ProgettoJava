package esterno;

import java.io.Serializable;

public final class Fornitore implements Cloneable, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5245332314076965305L;
	private String nome;
	private String pIva;
	private Prodotto prodottoFornito;
	
	public Fornitore(String nome, String pIva, Prodotto prodottoFornito) {
		this.nome = (nome==null?"":nome);
		this.pIva = (pIva==null?"":pIva);
		this.prodottoFornito = prodottoFornito;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getpIva() {
		return pIva;
	}
	
	public Prodotto getProdottoFornito() {
		return prodottoFornito;
	}
	
	public String toString() {
		return getClass().getName() + "[nome=" + nome + ", pIva=" + pIva + ", prodottoFornito=" + prodottoFornito + "]";
	}
	
	public boolean equals(Object o) {
		if(o==null) return false;
		if(getClass()!=o.getClass()) return false;
		Fornitore f = (Fornitore) o;
		return nome.equals(f.getNome()) && pIva.equals(f.getpIva()) && prodottoFornito.equals(f.getProdottoFornito());
	}
	
	public Fornitore clone() {
		try {
			Fornitore clone = (Fornitore) super.clone();
			clone.prodottoFornito = prodottoFornito;
			return clone;
		}
		catch(CloneNotSupportedException e) {
			return null;
		}
	}
	
}
