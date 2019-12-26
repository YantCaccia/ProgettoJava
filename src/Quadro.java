
public class Quadro extends Lavoratore implements Responsabile{
	/*
	 * Numero di squadre di cui è stato caposquadra*/
	private int numeroSquadre;
	
	public Quadro(String nome, String cognome, String codFis) {
		super(nome, cognome, codFis);
		this.numeroSquadre = 0;
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
	
	public String toString() {
		return super.toString() + "[numeroSquadre=" + numeroSquadre + "]";
	}
	
	public boolean equals(Object o) {
		if(super.equals(o)==false) return false;
		Quadro q = (Quadro) o;
		return numeroSquadre==q.getNumeroSquadre();
	}
	
	public Quadro clone() {
		Quadro clone = (Quadro) super.clone();
		clone.numeroSquadre = this.numeroSquadre;
		return clone;
	}
	
}
