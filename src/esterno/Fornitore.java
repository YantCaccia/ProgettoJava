package esterno;

public class Fornitore {
	
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
	
}
