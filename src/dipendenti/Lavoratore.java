package dipendenti;

import java.io.Serializable;

public abstract class Lavoratore implements Cloneable, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4425571456142179588L;
	private String nome;
	private String cognome;
	private String codFis;
	
	public Lavoratore(String nome, String cognome, String codFis) {
		this.nome = (nome==null?"":nome);
		this.cognome = (cognome==null?"":cognome);
		this.codFis = (codFis==null?"":codFis);
	}
	
	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}
	
	public String getCodFis() {
		return codFis;
	}
	
	public String toString() {
		return getClass().getName() + "[nome=" + nome + ",cognome=" + cognome + ",codFis=" + codFis + "]";
	}
	
	public boolean equals(Object o) {
		if(o==null) return false;
		if(getClass()!=o.getClass()) return false;
		Lavoratore l = (Lavoratore) o;
		return nome.equals(l.getNome()) && cognome.equals(l.getCognome()) && codFis.equals(l.getCodFis());
	}
	
	public Lavoratore clone() {
		try {
			return (Lavoratore) super.clone();
		}
		catch(CloneNotSupportedException e) {
			return null;
		}
	}
	
}