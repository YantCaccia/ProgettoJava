import java.util.ArrayList;

public class Squadra {
	
	private Quadro caposquadra;
	private ArrayList<Operaio> listaOperai;
	
	public Squadra(Quadro caposqudra) throws LavoratoreImpegnatoException {
		if(caposquadra.isBusy()) {
			throw new LavoratoreImpegnatoException("Il lavoratore che hai cercato di aggiungere alla squadra è già impegnato");
		}
		this.caposquadra = caposqudra;
		listaOperai = new ArrayList<Operaio>();
	}
	
	public void addOperaio(Operaio o) throws LavoratoreImpegnatoException {
		if(o.isBusy()) {
			throw new LavoratoreImpegnatoException("Il lavoratore che hai cercato di aggiungere alla squadra è già impegnato");
		}
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
