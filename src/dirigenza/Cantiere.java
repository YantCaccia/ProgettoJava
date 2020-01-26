package dirigenza;
import java.io.Serializable;

import dipendenti.Dirigente;
import dipendenti.Lavoratore;
import dipendenti.Quadro;
import dipendenti.Responsabile;

/**
 * Descrive un Cantiere.
 * Ha un nome, un valore, un responsabile e una squadra.
 * Non puo' essere istanziato dall'esterno poiche' e' necessario utilizzare i metodi della classe RepartoOperativo
 * per gestire un Cantiere e la sua Squadra
 * @author antoc
 *
 */
public class Cantiere implements Cloneable, Serializable {
	
	private static final long serialVersionUID = 2460198075155216056L;
	private String nome;
	private int valore;
	private Responsabile resp;
	private Squadra squadra;
	
	/**
	 * Istanzia un Cantiere con i parametri specificati.
	 * Utilizzato dai metodi della classe RepartoOperativo, necessaria per gestire un Cantiere
	 * @param nome il nome del cantiere
	 * @param valore il valore del cantiere
	 * @param resp il responsabile del cantiere. Deve essere un Lavoratore che implementa l'interfaccia Responsabile
	 * @param s la squadra assegnata al cantiere
	 * @throws ResponsabileNonDirigenteExcpetion viene lanciata se il responsabile che si e' tentato di assegnare al cantiere non e' un dirigente
	 * e il valore del cantiere supera VALORE_MAX (500000)
	 * @throws SquadraIsAlreadyAssignedExcpetion se la squadra che si tenta di assegnare al cantiere e' gia' assegnata
	 * (ad ogni cantiere dovrebbe essere assegnata una squadra creata di proposito)
	 */
	protected Cantiere(String nome, int valore, Responsabile resp, Squadra s) throws ResponsabileNonDirigenteExcpetion  {
		this.nome = (nome==null?"":nome);
		if(valore > VALORE_MAX && !(resp instanceof Dirigente)) {
			throw new ResponsabileNonDirigenteExcpetion("Il Responsabile di questo cantiere deve essere un Dirigente");	
		}
		if(s.isAssigned()) {
			throw new SquadraIsAlreadyAssignedExcpetion("La squadra non puo' essere assegnata ad un altro cantiere poiche' e' gia'  impegnata");
		}
		this.valore = valore;
		this.resp = resp;
		this.squadra = s;
	}
	
	/**
	 * accedi al nome del cantiere
	 * @return il nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * accedi al valore del cantiere
	 * @return il valore
	 */
	public int getValore() {
		return valore;
	}
	
	/**
	 * imposta un nuovo nome per il cantiere
	 * @param s il nuovo nome
	 */
	public void setNome(String s) {
		nome = (s==null?"":s);
	}
	
	/**
	 * imposta un nuovo valore per il cantiere
	 * @param valore il nuovo valore
	 */
	public void setValore(int valore) {
		this.valore = valore;
	}
	
	/**
	 * accedi al responsabile del cantiere
	 * @return il responsabile
	 */
	public Responsabile getResp() {
		return resp;
	}
	
	/**
	 * imposta un nuovo responsabile per il cantiere, che sostituisce il vecchio
	 * accessibile attraverso la classe Reparto Operativo
	 * @param newResp il nuovo responsabile
	 * @throws ResponsabileNonDirigenteExcpetion se il valore del cantiere supera VALORE_MAX e
	 * il nuovo responsabile non e' un dirigente 
	 */
	protected void setResp(Responsabile newResp) throws ResponsabileNonDirigenteExcpetion {
		if(valore > VALORE_MAX && !newResp.getClass().getName().equals("Dirigente")) {
			throw new ResponsabileNonDirigenteExcpetion("Il Responsabile di questo cantiere deve essere un Dirigente");	
		}
		this.resp = newResp;
	}
	
	/**
	 * accedi alla squadra assegnata al cantiere
	 * @return la squadra
	 */
	public Squadra getSquadra() {
		return squadra;
	}

	/**
	 * imposta una nuova squadra per il cantiere
	 * @param s la nuova squadra
	 */
	public void setSquadra(Squadra s) {
		this.squadra = s;
	}
	
	public String toString() {
		return getClass().getName() + "[nome=" + nome + ", valore=" + valore + ", resp=" + resp + ", squadra=" + squadra + "]";
	}
	
	public boolean equals(Object o) {
		if(o==null) return false;
		if(getClass()!=o.getClass()) return false;
		Cantiere c = (Cantiere) o;
		return this.nome.equals(c.getNome()) && this.valore==c.getValore() && ((Lavoratore)this.resp).equals((Lavoratore)c.getResp()) && this.squadra.equals(c.getSquadra());
	}
	
	public Cantiere clone() {
		try {
			Cantiere clone = (Cantiere) super.clone();
			clone.squadra = squadra.clone();
			if(resp instanceof Dirigente) {
				clone.resp = (Responsabile)((Dirigente) resp).clone();
			}
			else {
				clone.resp = (Responsabile)((Quadro) resp).clone();
			}
			return clone;
		}
		catch(CloneNotSupportedException e) {
			return null;
		}
	}
	
	/* Massimo importo in euro dopo il quale e' necessario
	 * che il responsabile sia un dirigente */
	private static final int VALORE_MAX = 500000;

}
