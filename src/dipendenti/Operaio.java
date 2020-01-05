package dipendenti;

public class Operaio extends Lavoratore {
	/*
	 * Numero di cantieri a cui ha lavorato in un mese*/
	private int numeroCantieri;
	private boolean busy; 
	
	public Operaio(String nome, String cognome, String codFis) {
		super(nome, cognome, codFis);
		this.numeroCantieri = 0;
	}
	
	public Operaio(String nome, String cognome, String codFis, int numerocantieri) {
		super(nome, cognome, codFis);
		this.numeroCantieri = numerocantieri;
	}
	
	public int getNumeroCantieri() {
		return numeroCantieri;
	}
	
	public void setNumeroCantieri(int newNumeroCantieri) {
		this.numeroCantieri = newNumeroCantieri;
	}
	
	public void incrementNumeroCantieri() {
		numeroCantieri++;
	}
	
	public boolean isBusy() {
		return busy;
	}
	
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
