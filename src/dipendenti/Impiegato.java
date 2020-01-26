package dipendenti;
/**
 * 
 * Estende Lavoratore, descrive un Impiegato che ha un numero di ore di lavoro settimanali definito
 * @author antoc
 */
public class Impiegato extends Lavoratore {

	private static final long serialVersionUID = -2525203859577914311L;

	public int oreLavoro;
	
	/**
	 * Istanzia un Impiegato con i parametri specificati
	 * @param nome il nome dell'Impiegato
	 * @param cognome il cognome dell'Impiegato
	 * @param codFis il codice fiscale dell'Impiegato
	 * @param oreLavoro le ore di lavoro settimanali previste dal contratto dell'Impiegato
	 */
	public Impiegato(String nome, String cognome, String codFis, int oreLavoro) {
		super(nome, cognome, codFis);
		this.oreLavoro = oreLavoro;
	}
	
	/**
	 * accedi al numero di ore di lavoro settimanali previste dal contratto per l'Impiegato
	 * @return il numero di ore di lavoro settimanali per l'Impiegato
	 */
	public int getOreLavoro() {
		return oreLavoro;
	}
	
	/**
	 * imposta un nuovo numero di ore di lavoro settimanali per l'Impiegato
	 * @param newOreLavoro il nuovo numero di ore di lavoro da assegnare all'Impiegato
	 */
	public void setOreLavoro(int newOreLavoro) {
		this.oreLavoro = newOreLavoro;
	}
	
	public String toString() {
		return super.toString() + "[oreLavoro=" + oreLavoro + "]";
	}
	
	public boolean equals(Object o) {
		if(super.equals(o)==false) return false;
		Impiegato i = (Impiegato) o;
		return oreLavoro==i.getOreLavoro();
	}
	
	public Impiegato clone() {
		Impiegato clone = (Impiegato) super.clone();
		clone.oreLavoro = this.oreLavoro;
		return clone;
	}
	
}
