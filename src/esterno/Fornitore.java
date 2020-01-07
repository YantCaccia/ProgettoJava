package esterno;

public final class Fornitore implements Cloneable {
	
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
