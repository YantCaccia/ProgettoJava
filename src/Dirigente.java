
public class Dirigente extends Lavoratore {
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
	
}
