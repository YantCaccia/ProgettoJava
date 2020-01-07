package dirigenza;
import java.util.ArrayList;

import dipendenti.Operaio;
import dipendenti.Quadro;
import dipendenti.Responsabile;

public class RepartoOperativo {
	
	private ArrayList<Cantiere> cantieri; //lista dei cantieri aperti
	
	public RepartoOperativo() {
		cantieri = new ArrayList<Cantiere>();
	}
	
	public ArrayList<Cantiere> getCantieri(){
		ArrayList<Cantiere> toberet = new ArrayList<Cantiere>();
		for(Cantiere c:cantieri) {
			toberet.add(c.clone());
		}
		return toberet;
	}
	
	public void addCantiere(Cantiere c) {
		cantieri.add(c);
	}
	
	/*Gestione Cantiere*/
	public Cantiere createCantiere(int valore, Responsabile resp, Squadra s) throws ResponsabileNonDirigenteExcpetion {
		Cantiere c = new Cantiere(valore, resp, s);
		for(Operaio o:s.getListaOperai()) {
			o.incrementNumeroCantieri();
		}
		s.setAssigned(true);
		cantieri.add(c);
		return c;
	}
	
	/*
	 * quando l'impresa ha finito il lavoro in un cantiere*/
	public Cantiere removeCantiere(Cantiere c) {
		int tmp = cantieri.indexOf(c);
		if(tmp<0) {
			return null;
		}
		else {
			for(Operaio o:c.getSquadra().getListaOperai()) {
				o.setBusy(false);
			}
			c.getSquadra().getCaposquadra().setBusy(false);
			return cantieri.remove(tmp);
		}
	}
	
	public void changeResponsabileCantiere(Responsabile newResp, Cantiere c) throws ResponsabileNonDirigenteExcpetion {
		c.setResp(newResp);
	}
	
	/*Gestione Squadra*/
	public Squadra createSquadra(Quadro caposquadra) throws LavoratoreImpegnatoException {
		Squadra s = new Squadra(caposquadra);
		caposquadra.incrementNumeroSquadre();
		caposquadra.setBusy(true);
		return s;
	}
	
	public void addOperaioToSquadra(Operaio o, Squadra s) throws LavoratoreImpegnatoException {
		if(o.isBusy()) {
			throw new LavoratoreImpegnatoException("Il lavoratore che hai cercato di aggiungere alla squadra è già impegnato");
		}
		s.addOperaio(o);
		o.setBusy(true);
	}
	
	/*----*/
	public ArrayList<Cantiere> getCantieriByValue(int min, int max){
		ArrayList<Cantiere> toBeRet = new ArrayList<Cantiere>();
		for(Cantiere c:cantieri) {
			if(c.getValore()>=min&&c.getValore()<=max) {
				toBeRet.add(c);
			}
		}
		return toBeRet;
	}
	
}
