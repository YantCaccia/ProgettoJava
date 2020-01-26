package dirigenza;
import java.io.Serializable;
import java.util.ArrayList;

import dipendenti.Operaio;
import dipendenti.Quadro;

/**
 * Descrive una Squadra.
 * Ha un caposquadra, una lista di Operai e uno stato.
 * Non puo' essere istanziata dall'esterno poiche' e' necessario utilizzare i metodi della classe RepartoOperativo
 * per gestire un Cantiere e la sua Squadra
 * @author antoc
 *
 */
public class Squadra implements Cloneable, Serializable{
	
	private static final long serialVersionUID = 5676147365510359805L;
	private Quadro caposquadra;
	private boolean assigned;
	private ArrayList<Operaio> listaOperai;
	
	/**
	 * Istanzia una Squadra con i parametri specificati
	 * @param caposquadra il caposquadra
	 * @throws LavoratoreImpegnatoException se si prova ad assegnare alla squadra come caposquadra un Quadro gia' impegnato
	 */
	protected Squadra(Quadro caposquadra) throws LavoratoreImpegnatoException {
		if(caposquadra.isBusy()) {
			throw new LavoratoreImpegnatoException("Il lavoratore che hai cercato di aggiungere alla squadra [" + caposquadra.getNome() + " " 
					+ caposquadra.getCognome() + "] e' gia'  impegnato");
		}
		this.caposquadra = caposquadra;
		this.assigned = false;
		listaOperai = new ArrayList<Operaio>();
	}
	
	/**
	 * accedi al caposquadra
	 * @return il caposquadra
	 */
	public Quadro getCaposquadra() {
		return caposquadra;
	}
	
	/**
	 * imposta un nuovo caposquadra
	 * @param newCaposquadra il nuovo caposquadra
	 * @throws LavoratoreImpegnatoException se si prova ad assegnare alla squadra come caposquadra un Quadro gia' impegnato
	 */
	public void setCaposquadra(Quadro newCaposquadra) throws LavoratoreImpegnatoException {
		if(newCaposquadra.isBusy()) {
			throw new LavoratoreImpegnatoException("Il lavoratore che hai cercato di aggiungere alla squadra [" + caposquadra.getNome() + " " 
					+ caposquadra.getCognome() + "] e' gia'  impegnato");
		}
		this.caposquadra = newCaposquadra;
	}
	
	/**
	 * accedi alla lista do operai
	 * @return la lista di operai
	 */
	public ArrayList<Operaio> getListaOperai(){
		return listaOperai;
	}
	
	/**
	 * aggiungi un operaio alla squadra
	 * @param o l'operaio da aggiungere
	 * @throws LavoratoreImpegnatoException se l'operaio che si è provato ad aggiungere alla squadra e' gia' impegnato
	 */
	protected void addOperaio(Operaio o) throws LavoratoreImpegnatoException{
		if(o.isBusy()) {
			throw new LavoratoreImpegnatoException("Il lavoratore che hai cercato di aggiungere alla squadra e' gia'  impegnato: " + o.getNome() + "" + o.getCognome());
		}
		listaOperai.add(o);
	}
	
	
	/**
	 * accedi allo stato della squadra
	 * @return true se e' impegnata, false altrimenti
	 */
	public boolean isAssigned() {
		return assigned;
	}
	
	/**
	 * imposta un nuovo stato per la squadra
	 * @param state il nuovo stato
	 */
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
