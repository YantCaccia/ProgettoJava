package dirigenza;
import dipendenti.Dirigente;
import dipendenti.Lavoratore;
import dipendenti.Quadro;
import dipendenti.Responsabile;

public class Cantiere implements Cloneable {
	
	private int valore;
	Responsabile resp;
	Squadra squadra;
	
	protected Cantiere(int valore, Responsabile resp, Squadra s) throws ResponsabileNonDirigenteExcpetion  {
		if(valore > VALORE_MAX && !resp.getClass().getName().equals("Dirigente")) {
			throw new ResponsabileNonDirigenteExcpetion("Il Responsabile di questo cantiere deve essere un Dirigente");	
		}
		if(s.isAssigned()) {
			throw new SquadraIsAlreadyAssignedExcpetion("La squadra non può essere assegnata ad un altro cantiere poichè è già impegnata");
		}
		this.valore = valore;
		this.resp = resp;
		this.squadra = s;
	}

	public int getValore() {
		return valore;
	}

	public void setValore(int valore) {
		this.valore = valore;
	}

	public Responsabile getResp() {
		return resp;
	}

	protected void setResp(Responsabile newResp) throws ResponsabileNonDirigenteExcpetion {
		if(valore > VALORE_MAX && !newResp.getClass().getName().equals("Dirigente")) {
			throw new ResponsabileNonDirigenteExcpetion("Il Responsabile di questo cantiere deve essere un Dirigente");	
		}
		this.resp = newResp;
	}

	public Squadra getSquadra() {
		return squadra;
	}

	public void setSquadra(Squadra s) {
		this.squadra = s;
	}
	
	public String toString() {
		return getClass().getName() + "[valore=" + valore + ", resp=" + resp + ", squadra=" + squadra + "]";
	}
	
	public boolean equals(Object o) {
		if(o==null) return false;
		if(getClass()!=o.getClass()) return false;
		Cantiere c = (Cantiere) o;
		return this.valore==c.getValore() && ((Lavoratore)this.resp).equals((Lavoratore)c.getResp()) && this.squadra.equals(c.getSquadra());
	}
	
	public Cantiere clone() {
		try {
			Cantiere clone = (Cantiere) super.clone();
			clone.squadra = squadra.clone();
			if(resp instanceof Dirigente) {
				clone.resp = (Responsabile)((Dirigente) resp).clone();
			}
			else {
				clone.resp = (Responsabile)((Quadro) resp).clone();
			}
			return clone;
		}
		catch(CloneNotSupportedException e) {
			return null;
		}
	}
	
	/*
	 * Massimo importo in euro dopo il quale è necessario
	 * che il responsabile sia un dirigente */
	private static final int VALORE_MAX = 500000;

}
