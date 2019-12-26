
public class Quadro extends Lavoratore {
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
}
