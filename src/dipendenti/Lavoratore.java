package dipendenti;

import java.io.Serializable;

/**
 * Descrive un Lavoratore dell'Impresa Edile. 
 * Un Lavoratore ha un nome, cognome e codice fiscale.
 * E' astratta perche' e' necessario istanziare per ogni lavoratore una sottoclasse di quesa classe.
 * @author antoc
 * 
 */

public abstract class Lavoratore implements Cloneable, Serializable {
	
	private static final long serialVersionUID = -4425571456142179588L;
	private String nome;
	private String cognome;
	private String codFis;
	
	/**
	 * Istanzia un Lavoratore con i parametri specificati.
	 * Non puo' essere utilizzato in quanto e' una classe astratta.
	 * Utilizzato nei costruttori delle sue sottoclassi.
	 * @param nome il nome del Lavoratore
	 * @param cognome il cognome del Lavoratore
	 * @param codFis il codice fiscale del Lavoratore
	 */
	public Lavoratore(String nome, String cognome, String codFis) {
		this.nome = (nome==null?"":nome);
		this.cognome = (cognome==null?"":cognome);
		this.codFis = (codFis==null?"":codFis);
	}
	
	/**
	 * accedi al nome del lavoratore
	 * @return il nome del lavoratore
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * accedi al cognome del lavoratore
	 * @return il cognome del lavoratore
	 */
	public String getCognome() {
		return cognome;
	}
	
	/**
	 * accedi al codice fiscale del lavoratore
	 * @return il codice fiscale del lavoratore
	 */
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