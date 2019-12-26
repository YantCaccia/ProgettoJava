
public class Operaio extends Lavoratore {
	/*
	 * Numero di cantieri a cui ha lavorato in un mese*/
	private int numeroCantieri;
	
	public Operaio(String nome, String cognome, String codFis) {
		super(nome, cognome, codFis);
		this.numeroCantieri = 0;
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
	
	public String toString() {
		return super.toString() + "[numeroCantieri=" + numeroCantieri + "]";
	}
	
	public boolean equals(Object o) {
		if(super.equals(o)==false) return false;
		Operaio op = (Operaio) o;
		return numeroCantieri==op.getNumeroCantieri();
	}
	
	public Operaio clone() {
		Operaio clone = (Operaio) super.clone();
		clone.numeroCantieri = this.numeroCantieri;
		return clone;
	}
	
}
