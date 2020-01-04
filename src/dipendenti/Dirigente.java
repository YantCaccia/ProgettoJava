package dipendenti;

public class Dirigente extends Lavoratore implements Responsabile {
	/**
	 * Ruolo che riveste all'interno dell'impresa*/
	private Ruolo ruolo;
	
	public Dirigente(String nome, String cognome, String codFis, Ruolo r) {
		super(nome, cognome, codFis);
		this.ruolo = r;
	}
	
	public Ruolo getRuolo(){
		return ruolo;
	}
	
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
