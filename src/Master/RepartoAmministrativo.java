package Master;
import java.util.ArrayList;

import Dipendenti.Dirigente;
import Dipendenti.Impiegato;
import Dipendenti.Lavoratore;
import Dipendenti.Operaio;
import Dipendenti.Quadro;
import Esterno.Cliente;
import Esterno.Fornitore;
import Esterno.Locale;
import Esterno.Prodotto;

public class RepartoAmministrativo {
		
	private ArrayList<Lavoratore> lavoratori;
	private ArrayList<Fornitore> fornitori;
	private ArrayList<Locale> locali;
	private ArrayList<Cliente> clienti;
	
	public RepartoAmministrativo() {
		lavoratori = new ArrayList<Lavoratore>();
		fornitori = new ArrayList<Fornitore>();
		locali = new ArrayList<Locale>();
		clienti = new ArrayList<Cliente>();
	}
	
	public ArrayList<Lavoratore> getLavoratori(){
		return lavoratori;
	}
	
	public ArrayList<Fornitore> getFornitori(){
		return fornitori;
	}
	
	public ArrayList<Locale> getLocali(){
		return locali;
	}
	
	public ArrayList<Cliente> getClienti(){
		return clienti;
	}
	
	public void addLavoratore(Lavoratore l) {
		lavoratori.add(l);
		if((l instanceof Dirigente)||(l instanceof Impiegato)) {
			l.setBusy(true);
		}
	}
	
	public void addFornitore(Fornitore f) {
		fornitori.add(f);
	}
	
	public void addLocale(Locale l) {
		locali.add(l);
	}
	
	public void addCliente(Cliente c) {
		clienti.add(c);
	}
	
	public int calcolaStipendio(Impiegato i) {
		return STIPENDIO_BASE + (PAGA_PER_ORA*i.getOreLavoro());
	}
	
	public int calcolaStipendio(Operaio o) {
		return STIPENDIO_BASE + (PAGA_PER_CANTIERE*o.getNumeroCantieri());
	}
	
	public int calcolaStipendio(Quadro q) {
		return STIPENDIO_BASE + (PAGA_PER_SQUADRA*q.getNumeroSquadre());
	}
	
	public int calcolaStipendio(Dirigente d) {
		int bonus;
		switch(d.getRuolo()) {
		case AMMINISTRATORE:
			bonus = 2000;
			break;
		case VICEDIRETTORE:
			bonus = 3000;
			break;
		case DIRETTORE:
			bonus = 4000;
			break;
		default:
			bonus = 0; //impossible
		}
		return STIPENDIO_BASE + bonus;
	}
	
	public ArrayList<Lavoratore> getLavoratoriNonImpegnati(){
		ArrayList<Lavoratore> toBeRet = new ArrayList<Lavoratore>();
		for (Lavoratore l:lavoratori) {
			if(!l.isBusy()) {
				toBeRet.add(l);
			}
		}
		return toBeRet;
	}
	
	public ArrayList<Lavoratore> getLavoratoriImpegnati(){
		ArrayList<Lavoratore> toBeRet = new ArrayList<Lavoratore>();
		for (Lavoratore l:lavoratori) {
			if(l.isBusy()) {
				toBeRet.add(l);
			}
		}
		return toBeRet;
	}
	
	public ArrayList<Fornitore> getFornitoreByProdotto(Prodotto p){
		ArrayList<Fornitore> toBeRet = new ArrayList<Fornitore>();
		for(Fornitore f:fornitori) {
			if(f.getProdottoFornito()==p) {
				toBeRet.add(f);
			}
		}
		return toBeRet;
	}
	
	public ArrayList<Locale> getLocaleByCitta(String città){
		ArrayList<Locale> toBeRet = new ArrayList<Locale>();
		for(Locale l:locali) {
			if(l.getCitta().equals(città)) {
				toBeRet.add(l);
			}
		}
		return toBeRet;
	}
	
	private static final int STIPENDIO_BASE = 1500;
	private static final int PAGA_PER_ORA = 15;
	private static final int PAGA_PER_CANTIERE = 500;
	private static final int PAGA_PER_SQUADRA = 1000;
	
}
