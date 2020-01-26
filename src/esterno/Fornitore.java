package esterno;

import java.io.Serializable;

/**
 * Descrive un Fornitore dell'Impresa Edile.
 * Ha un nome, una partita iva e una tipologia di prodotto fornito
 * @author antoc
 *
 */
public final class Fornitore implements Cloneable, Serializable {

	private static final long serialVersionUID = 5245332314076965305L;
	private String nome;
	private String pIva;
	private Prodotto prodottoFornito;
	
	/**
	 * Istanzia un fornitore con i parametri specificati
	 * @param nome il nome del fornitore
	 * @param pIva la partita iva del fornitore
	 * @param prodottoFornito la tipologia di prodotto fornito
	 */
	public Fornitore(String nome, String pIva, Prodotto prodottoFornito) {
		this.nome = (nome==null?"":nome);
		this.pIva = (pIva==null?"":pIva);
		this.prodottoFornito = prodottoFornito;
	}
	
	/**
	 * accedi al nome del fornitore
	 * @return il nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * accedi alla partita iva del fornitore
	 * @return la partita iva
	 */
	public String getpIva() {
		return pIva;
	}
	
	/**
	 * accedi al prodotto fornito dal fornitore
	 * @return la tipologia di prodotto fornito 
	 */
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
