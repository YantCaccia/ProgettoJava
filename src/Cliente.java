
public class Cliente {
	
	private String nome;
	private String pIva;
	
	public Cliente(String nome, String pIva) {
		this.nome = (nome==null?"":nome);
		this.pIva = (pIva==null?"":pIva);
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getpIva() {
		return pIva;
	}
}
