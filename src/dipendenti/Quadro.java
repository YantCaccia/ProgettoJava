package dipendenti;
/**
 * Estende Lavoratore, descrive un Quadro con un numero di squadre di cui e' caposquadra
 * e uno stato - busy - che puo' essere vero o falso
 * @author antoc
 *
 */
public class Quadro extends Lavoratore implements Responsabile{

	private static final long serialVersionUID = 3918369214725947669L;
	private int numeroSquadre;
	private boolean busy;
	
	/**
	 * Istanzia un Quadro con i parametri specificati e numero di squadre di cui e' stato caposquadra a 0
	 * @param nome il nome del quadro
	 * @param cognome il cognome del quadro
	 * @param codFis il codice fiscale del quadro
	 */
	public Quadro(String nome, String cognome, String codFis) {
		super(nome, cognome, codFis);
		this.numeroSquadre = 0;
	}
	
	/**
	 * Istanzia un Quadro con i parametri specificati
	 * @param nome il nome del quadro
	 * @param cognome il cognome del quadro
	 * @param codFis il codice fiscale del quadro
	 * @param numeroSquadre il numero di squadre di cui e' stato caposquadra il quadro
	 */
	public Quadro(String nome, String cognome, String codFis, int numeroSquadre) {
		super(nome, cognome, codFis);
		this.numeroSquadre = numeroSquadre;
	}
	
	/**
	 * accedi al numero di squadre di cui e' stato caposquadra 
	 * @return il numero di squadre
	 */
	public int getNumeroSquadre() {
		return numeroSquadre;
	}
	
	/**
	 * imposta un nuovo numero di squadre di cui il quadro e' stato caposquadra
	 * @param newNumeroSquadre il nuovo numero di squadre
	 */
	public void setNumeroSquadre(int newNumeroSquadre) {
		this.numeroSquadre = newNumeroSquadre;
	}
	
	/**
	 * incrementa di 1 il numero di squadre di cui e' stato caposquadra il quadro
	 */
	public void incrementNumeroSquadre() {
		numeroSquadre++;
	}
	
	/**
	 * accedi allo stato del quadro
	 * @return true se e' busy, false se non e' busy
	 */
	public boolean isBusy() {
		return busy;
	}
	
	/**
	 * imposta il nuovo stato busy del quadro
	 * @param state il nuovo stato
	 */
	public void setBusy(boolean state) {
		this.busy = state;
	}
	
	public String toString() {
		return super.toString() + "[numeroSquadre=" + numeroSquadre + ", busy=" + busy + "]";
	}
	
	public boolean equals(Object o) {
		if(super.equals(o)==false) return false;
		Quadro q = (Quadro) o;
		return numeroSquadre==q.getNumeroSquadre() && busy==q.isBusy();
	}
	
	public Quadro clone() {
		Quadro clone = (Quadro) super.clone();
		clone.numeroSquadre = this.numeroSquadre;
		return clone;
	}
	
}
