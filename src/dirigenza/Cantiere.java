package dirigenza;
import dipendenti.Lavoratore;
import dipendenti.Responsabile;

public class Cantiere {
	
	private int valore;
	Responsabile resp;
	Squadra squadra;
	
	protected Cantiere(int valore, Responsabile resp, Squadra s) {
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

	protected void setResp(Responsabile newResp) {
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

}
