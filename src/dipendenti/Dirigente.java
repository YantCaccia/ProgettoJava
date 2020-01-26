package dipendenti;

/**
 * Estende Lavoratore, descrive un Dirigente che ha un partciolare Ruolo
 * @author antoc
 */
public class Dirigente extends Lavoratore implements Responsabile {
	
	private static final long serialVersionUID = 4111369283592845736L;
	
	private Ruolo ruolo;
	
	/**
	 * Istanzia un Dipendente con i parametri specificati
	 * @param nome il nome del Dirigente
	 * @param cognome il cognome del Dirigente
	 * @param codFis il codice fiscale del Dirigente
	 * @param r il Ruolo del Dirigente
	 */
	public Dirigente(String nome, String cognome, String codFis, Ruolo r) {
		super(nome, cognome, codFis);
		this.ruolo = r;
	}
	
	/**
	 * accedi al Ruolo del dirigente
	 * @return il Ruolo del dirigente
	 */
	public Ruolo getRuolo(){
		return ruolo;
	}
	
	/**
	 * imposta un nuovo Ruolo per il dirigente
	 * @param r il nuovo Ruolo da assegnare al dirigente
	 */
	public void setRuolo(Ruolo r) {
		this.ruolo = r;
	}
	
	public String toString() {
		return super.toString() + "[ruolo=" + ruolo + "]";
	}
	
	public boolean equals(Object o) {
		if(super.equals(o)==false) return false;
		Dirigente d = (Dirigente) o;
		return ruolo==d.getRuolo();
	}
	
	public Dirigente clone() {
		Dirigente clone = (Dirigente) super.clone();
		clone.ruolo = this.ruolo;
		return clone;
	}
	
}
