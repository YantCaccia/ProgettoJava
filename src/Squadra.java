import java.util.ArrayList;

public class Squadra {
	private Quadro caposquadra;
	private ArrayList<Operaio> listaOperai;
	
	public Squadra(Quadro caposqudra) {
		//implementa controllo su impegno caposquadra
		this.caposquadra = caposqudra;
		listaOperai = new ArrayList<Operaio>();
	}
	
	public void addOperaio(Operaio o) {
		//implementa controllo su impegno operaio
		listaOperai.add(o);
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
}
