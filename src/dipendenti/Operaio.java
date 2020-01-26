package dipendenti;
/**
 * Estende Lavoratore, descrive un Operaio che ha un numero di cantieri al quale ha partecipato
 * e uno stato - busy - che puo' essere vero o falso
 * @author antoc
 *
 */
public class Operaio extends Lavoratore {

	private static final long serialVersionUID = 4978123532118939207L;
	private int numeroCantieri;
	private boolean busy; 
	
	/**
	 * Istanzia un Operaio con i parametri specificati, numero di cantieri a 0 e busy a falso
	 * @param nome il nome dell'operaio
	 * @param cognome il cognome dell'operaio
	 * @param codFis il codice fiscale dell'operaio
	 */
	public Operaio(String nome, String cognome, String codFis) {
		super(nome, cognome, codFis);
		this.numeroCantieri = 0;
		this.busy = false;
	}
	
	/**
	 * Istanzia un Operaio con i parametri specificati e busy a falso
	 * @param nome il nome dell'operaio
	 * @param cognome il cognome dell'operaio
	 * @param codFis il codice fiscale dell'operaio
	 * @param numerocantieri il numero di cantieri ai quali ha partecipato l'operaio
	 */
	public Operaio(String nome, String cognome, String codFis, int numerocantieri) {
		super(nome, cognome, codFis);
		this.numeroCantieri = numerocantieri;
		this.busy = false;
	}
	
	/**
	 * accedi al numero di cantieri ai quali ha partecipato l'operaio
	 * @return il numero di cantieri
	 */
	public int getNumeroCantieri() {
		return numeroCantieri;
	}
	
	/**
	 * imposta un nuovo numero di cantieri ai quali ha partecipato l'operaio
	 * @param newNumeroCantieri il nuovo numero di cantieri
	 */
	public void setNumeroCantieri(int newNumeroCantieri) {
		this.numeroCantieri = newNumeroCantieri;
	}
	
	/**
	 * incrementa di uno il numero di cantieri dell'operaio
	 */
	public void incrementNumeroCantieri() {
		numeroCantieri++;
	}
	
	/**
	 * accedi allo stato dell'operaio
	 * @return true se l'operaio e' busy, false se l'operaio non e' busy
	 */
	public boolean isBusy() {
		return busy;
	}
	
	/**
	 * imposta lo stato dell'operaio
	 * @param state il nuovo stato dell'operaio
	 */
	public void setBusy(boolean state) {
		this.busy = state;
	}
	
	public String toString() {
		return super.toString() + "[numeroCantieri=" + numeroCantieri + ", busy=" + busy + "]";
	}
	
	public boolean equals(Object o) {
		if(super.equals(o)==false) return false;
		Operaio op = (Operaio) o;
		return numeroCantieri==op.getNumeroCantieri() && busy==op.isBusy();
	}
	
	public Operaio clone() {
		Operaio clone = (Operaio) super.clone();
		clone.numeroCantieri = this.numeroCantieri;
		return clone;
	}
	
}
