package dipendenti;

public abstract class Lavoratore implements Cloneable {
	
	private String nome;
	private String cognome;
	private String codFis;
	private boolean busy;
	
	public Lavoratore(String nome, String cognome, String codFis) {
		this.nome = (nome==null?"":nome);
		this.cognome = (cognome==null?"":cognome);
		this.codFis = (codFis==null?"":codFis);
		this.busy = false;
	}
	
	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}
	
	public String getCodFis() {
		return codFis;
	}
	
	public boolean isBusy() {
		return busy;
	}
	
	public void setBusy(boolean state) {
		this.busy = state;
	}
	
	public String toString() {
		return getClass().getName() + "[nome=" + nome + ",cognome=" + cognome + ",codFis=" + codFis + ",busy=" + busy + "]";
	}
	
	public boolean equals(Object o) {
		if(o==null) return false;
		if(getClass()!=o.getClass()) return false;
		Lavoratore l = (Lavoratore) o;
		return nome.equals(l.getNome()) && cognome.equals(l.getCognome()) && codFis.equals(l.getCodFis()) && busy==l.isBusy();
	}
	
	public Lavoratore clone() {
		try {
			return (Lavoratore) super.clone();
		}
		catch(CloneNotSupportedException e) {
			return null;
		}
	}
	
}