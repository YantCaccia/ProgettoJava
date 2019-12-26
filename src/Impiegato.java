
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
}
