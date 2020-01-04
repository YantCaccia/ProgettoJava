package dipendenti;

public class Dirigente extends Lavoratore implements Responsabile {
	/**
	 * Ruolo che riveste all'interno dell'impresa*/
	private Ruolo r;
	
	public Dirigente(String nome, String cognome, String codFis, Ruolo r) {
		super(nome, cognome, codFis);
		this.r = r;
	}
	
	public Ruolo getRuolo(){
		return r;
	}
	
	public void setRuolo(Ruolo r) {
		this.r = r;
	}
	
	public String toString() {
		return super.toString() + "[r=" + r + "]";
	}
	
	public boolean equals(Object o) {
		if(super.equals(o)==false) return false;
		Dirigente d = (Dirigente) o;
		return r==d.getRuolo();
	}
	
	public Dirigente clone() {
		Dirigente clone = (Dirigente) super.clone();
		clone.r = this.r;
		return clone;
	}
	
}
