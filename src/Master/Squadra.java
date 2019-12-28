package Master;
import java.util.ArrayList;

import Dipendenti.Operaio;
import Dipendenti.Quadro;

public class Squadra {
	
	private Quadro caposquadra;
	private boolean assigned;
	private ArrayList<Operaio> listaOperai;
	
	protected Squadra(Quadro caposquadra) {
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
	
	protected boolean isAssigned() {
		return assigned;
	}
	
	protected void setAssigned(boolean state) {
		this.assigned = state;
	}
	
	public boolean equals(Object o) {
		if(o==null) return false;
		if(getClass()!=o.getClass()) return false;
		Squadra s = (Squadra) o;
		return this.caposquadra.equals(s.getCaposquadra()) && this.assigned==s.isAssigned() && this.listaOperai.equals(s.getListaOperai());
	}
}
