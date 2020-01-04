package dipendenti;

public class Impiegato extends Lavoratore {
	/*
	 * Ore di lavoro settimanali previste dal contratto*/
	private int oreLavoro;
	
	public Impiegato(String nome, String cognome, String codFis, int oreLavoro) {
		super(nome, cognome, codFis);
		this.oreLavoro = oreLavoro;
	}
	
	public int getOreLavoro() {
		return oreLavoro;
	}
	
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
