package dirigenza;
import java.io.Serializable;
import java.util.ArrayList;

import dipendenti.Operaio;
import dipendenti.Quadro;

public class Squadra implements Cloneable, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5676147365510359805L;
	private Quadro caposquadra;
	private boolean assigned;
	private ArrayList<Operaio> listaOperai;
	
	protected Squadra(Quadro caposquadra) throws LavoratoreImpegnatoException {
		if(caposquadra.isBusy()) {
			throw new LavoratoreImpegnatoException("Il lavoratore che hai cercato di aggiungere alla squadra è già impegnato");
		}
		this.caposquadra = caposquadra;
		this.assigned = false;
		listaOperai = new ArrayList<Operaio>();
	}
	
	public Quadro getCaposquadra() {
		return caposquadra;
	}
	
	public void setCaposquadra(Quadro newCaposquadra) {
		this.caposquadra = newCaposquadra;
	}
	
	public ArrayList<Operaio> getListaOperai(){
		return listaOperai;
	}
	
	protected void addOperaio(Operaio o){
		listaOperai.add(o);
	}
	
	public boolean isAssigned() {
		return assigned;
	}
	
	public void setAssigned(boolean state) {
		this.assigned = state;
	}
	
	public String toString() {
		return getClass().getName() + "[caposquadra=" + caposquadra + ", assigned=" + assigned + ", listaOperai=" + listaOperai + "]";
	}
	
	public boolean equals(Object o) {
		if(o==null) return false;
		if(getClass()!=o.getClass()) return false;
		Squadra s = (Squadra) o;
		return this.caposquadra.equals(s.getCaposquadra()) && this.assigned==s.isAssigned() && this.listaOperai.equals(s.getListaOperai());
	}
	
	public Squadra clone() {
		try {
			Squadra toBeRet = (Squadra) super.clone();
			toBeRet.caposquadra = caposquadra.clone();
			toBeRet.listaOperai = new ArrayList<Operaio>();
			for(Operaio o:listaOperai) {
				toBeRet.listaOperai.add(o.clone());
			}
			return toBeRet;
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
