package dipendenti;

public class Quadro extends Lavoratore implements Responsabile{
	/*
	 * Numero di squadre di cui è stato caposquadra*/
	private int numeroSquadre;
	private boolean busy;
	
	public Quadro(String nome, String cognome, String codFis) {
		super(nome, cognome, codFis);
		this.numeroSquadre = 0;
	}
	
	public Quadro(String nome, String cognome, String codFis, int numeroSquadre) {
		super(nome, cognome, codFis);
		this.numeroSquadre = numeroSquadre;
	}
	
	public int getNumeroSquadre() {
		return numeroSquadre;
	}
	
	public void setNumeroSquadre(int newNumeroSquadre) {
		this.numeroSquadre = newNumeroSquadre;
	}
	
	public void incrementNumeroSquadre() {
		numeroSquadre++;
	}
	
	public boolean isBusy() {
		return busy;
	}
	
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
