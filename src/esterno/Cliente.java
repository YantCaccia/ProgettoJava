package esterno;

import java.io.Serializable;
/**
 * Descrive un Cliente dell'Impresa Edile. 
 * Ha un nome ed una partita iva
 * @author antoc
 *
 */
public final class Cliente implements Cloneable, Serializable{
	
	private static final long serialVersionUID = -6563595343434607279L;
	private String nome;
	private String pIva;
	
	/**
	 * Istanzia un cliente con i parametri specificati
	 * @param nome il nome del cliente
	 * @param pIva la partita iva del cliente
	 */
	public Cliente(String nome, String pIva) {
		this.nome = (nome==null?"":nome);
		this.pIva = (pIva==null?"":pIva);
	}
	
	/**
	 * accedi al nome del cliente
	 * @return il nome del cliente
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * accedi alla partita iva del cliente
	 * @return la partita iva del cliente
	 */
	public String getpIva() {
		return pIva;
	}
	
	public String toString() {
		return getClass().getName() + "[nome=" + nome + ", pIva=" + pIva + "]";
	}
	
	public boolean equals(Object o) {
		if(o==null) return false;
		if(getClass()!=o.getClass()) return false;
		Cliente c = (Cliente) o;
		return nome.equals(c.getNome()) && pIva.equals(c.getpIva());
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
