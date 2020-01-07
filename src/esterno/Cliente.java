package esterno;

public class Cliente implements Cloneable{
	
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
	
	public String toString() {
		return getClass().getName() + "[nome=" + nome + ", pIva=" + pIva + "]";
	}
	
	public Cliente clone() {
		try {
		Cliente clone = (Cliente) super.clone();
		return clone;
		}
		catch(CloneNotSupportedException e) {
			return null;
		}
	}
}
