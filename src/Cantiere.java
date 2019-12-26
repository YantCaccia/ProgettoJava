
public class Cantiere {
	
	private int valore;
	Responsabile resp;
	Squadra s;
	
	public Cantiere(int valore, Responsabile resp, Squadra s) throws ResponsabileNonDirigenteExcpetion{
		this.valore = valore;
		if(this.valore > VALORE_MAX && !resp.getClass().getName().equals("Dirigente")) {
			throw new ResponsabileNonDirigenteExcpetion("Il Responsabile di questo cantiere deve essere un Dirigente");	
		}
		this.resp = resp;
		this.s = s;
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

	public void setResp(Responsabile resp) throws ResponsabileNonDirigenteExcpetion{
		if(this.valore > VALORE_MAX && !resp.getClass().getName().equals("Dirigente")) {
			throw new ResponsabileNonDirigenteExcpetion("Il Responsabile di questo cantiere deve essere un Dirigente");	
		}
		this.resp = resp;
	}

	public Squadra getS() {
		return s;
	}

	public void setS(Squadra s) {
		this.s = s;
	}

	
	/*
	 * Massimo importo in euro dopo il quale è necessario
	 * che il responsabile sia un dirigente */
	private final int VALORE_MAX = 500000;

}
