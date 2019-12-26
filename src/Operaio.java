
public class Operaio extends Lavoratore {
	/*
	 * Numero di cantieri a cui ha lavorato in un mese*/
	private int numeroCantieri;
	
	public Operaio(String nome, String cognome, String codFis) {
		super(nome, cognome, codFis);
		this.numeroCantieri = 0;
	}
	
	public void incrementNumeroCantieri() {
		numeroCantieri++;
	}
	
	public int getNumeroCantieri() {
		return numeroCantieri;
	}
	
	public void setNumeroCantieri(int newNumeroCantieri) {
		this.numeroCantieri = newNumeroCantieri;
	}
	
}
