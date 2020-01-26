package dirigenza;
import java.io.Serializable;
import java.util.ArrayList;

import dipendenti.Operaio;
import dipendenti.Quadro;
import dipendenti.Responsabile;

/**
 * Descrive il Reparto Operativo dell'Impresa Edile.
 * Ha una lista di cantieri attivi ai quali lavora l'Impresa.
 * @author antoc
 *
 */
public class RepartoOperativo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5246755874357306272L;
	private ArrayList<Cantiere> cantieri; //lista dei cantieri aperti
	
	/**
	 * Istanza un nuovo Reparto Operativo con la lista di cantieri attivi vuota
	 */
	public RepartoOperativo() {
		cantieri = new ArrayList<Cantiere>();
	}
	
	/**
	 * accedi alla lista dei cantieti attivi
	 * @return la lista di cantieri attivi
	 */
	public ArrayList<Cantiere> getCantieri(){
		return cantieri;
	}
	
	/**
	 * accedi alla lista dei cantieri attivi con un vincolo sul valore
	 * @param min valore minimo (il valore di ogni cantiere della lista risultante e' maggiore di questo intero)
	 * @param max valore massimo (il valore di ogni cantiere della lista risultante e' minore di questo intero)
	 * @return la lista di cantieri con valore compreso tra i parametri specificati
	 */
	public ArrayList<Cantiere> getCantieriByValue(int min, int max){
		ArrayList<Cantiere> toBeRet = new ArrayList<Cantiere>();
		for(Cantiere c:cantieri) {
			if(c.getValore()>=min&&c.getValore()<=max) {
				toBeRet.add(c);
			}
		}
		return toBeRet;
	}
	
	/**
	 * aggiungi un cantiere alla lista dei cantieri attivi
	 * @param c il cantiere da aggiungere
	 */
	public void addCantiere(Cantiere c) {
		cantieri.add(c);
	}
	
	/*Gestione Cantiere*/
	
	/**
	 * Istanza un nuovo cantiere, lo aggiunge alla lista dei cantieri attivi, imposta lo stato della squadra addetta su occupato e
	 * per ogni opeario facente parte della squadra incrementa il numero di cantieri al quale egli ha partecipato
	 * @param nome il nome del cantiere
	 * @param valore il valore del cantiere
	 * @param resp il responsabile del cantiere
	 * @param s la squadra addetta al cantiere
	 * @return il nuovo cantiere
	 * @throws ResponsabileNonDirigenteExcpetion se il cantiere vale piu' di 500000 e il responsabile indicato non e' un Dirigente
	 */
	public Cantiere createCantiere(String nome, int valore, Responsabile resp, Squadra s) throws ResponsabileNonDirigenteExcpetion {
		Cantiere c = new Cantiere(nome, valore, resp, s);
		for(Operaio o:s.getListaOperai()) {
			o.incrementNumeroCantieri();
		}
		s.setAssigned(true);
		cantieri.add(c);
		return c;
	}
	
	/**
	 * Rimuove un cantiere dalla lista dei cantieri attivi e libera la relativa squadra.
	 * E' utilizzato quando l'Impresa Edile ha terminato il lavoro su un cantiere
	 * @param c il cantiere da rimuovere
	 * @return il cantiere rimosso
	 */
	public Cantiere removeCantiere(Cantiere c) {
		int tmp = cantieri.indexOf(c);
		if(tmp<0) {
			return null;
		}
		else {
			freeSquadra(c.getSquadra());
			return cantieri.remove(tmp);
		}
	}
	
	/**
	 * Imposta un nuovo responsabile per un cantiere
	 * @param newResp il nuovo responsabile
	 * @param c il cantiere a cui cambiare responsabile
	 * @throws ResponsabileNonDirigenteExcpetion se il cantiere vale piu' di 500000 e il responsabile indicato non e' un Dirigente
	 */
	public void changeResponsabileCantiere(Responsabile newResp, Cantiere c) throws ResponsabileNonDirigenteExcpetion {
		c.setResp(newResp);
	}
	
	/*Gestione Squadra*/
	
	/**
	 * Istanzia una nuova squadra con lista di operai vuota e caposquadra specificato.
	 * Incrementa il numero delle squadre di cui e' stato caposquadra il Quadro specificato e ne imposta lo stato su occupato
	 * @param caposquadra il caposquadra della squadra
	 * @return la nuova squadra
	 * @throws LavoratoreImpegnatoException se il caposquadra e' gia' impegnato
	 */
	public Squadra createSquadra(Quadro caposquadra) throws LavoratoreImpegnatoException {
		Squadra s = new Squadra(caposquadra);
		caposquadra.incrementNumeroSquadre();
		caposquadra.setBusy(true);
		return s;
	}
	
	/**
	 * Da utilizzare quando non e' piu' necessaria una squadra.
	 * Imposta lo stato di tutti i componenti della squadra (compreso il caposquadra) su libero
	 * @param s la squadra da liberare
	 */
	public void freeSquadra(Squadra s) {
		for(Operaio o:s.getListaOperai()) {
			o.setBusy(false);
		}
		s.getCaposquadra().setBusy(false);
	}

	/**
	 * Aggiunge l'operaio specificato alla squadra specificata
	 * @param o l'operaio
	 * @param s la squadra
	 * @throws LavoratoreImpegnatoException se l'operaio e' gia' impegnato
	 */
	public void addOperaioToSquadra(Operaio o, Squadra s) throws LavoratoreImpegnatoException {
		s.addOperaio(o);
		o.setBusy(true);
	}
	
}
