package dirigenza;
import java.util.ArrayList;

import dipendenti.Dirigente;
import dipendenti.Impiegato;
import dipendenti.Lavoratore;
import dipendenti.Operaio;
import dipendenti.Quadro;
import esterno.Cliente;
import esterno.Fornitore;
import esterno.Locale;
import esterno.Prodotto;

public class RepartoAmministrativo {
		
	private ArrayList<Lavoratore> lavoratori;
	private ArrayList<Operaio> operai;
	private ArrayList<Impiegato> impiegati;
	private ArrayList<Dirigente> dirigenti;
	private ArrayList<Quadro> quadri;
	private ArrayList<Fornitore> fornitori;
	private ArrayList<Locale> locali;
	private ArrayList<Cliente> clienti;
	
	public RepartoAmministrativo() {
		lavoratori = new ArrayList<Lavoratore>();
		dirigenti = new ArrayList<Dirigente>();
		operai= new ArrayList<Operaio>();
		impiegati = new ArrayList<Impiegato>();
		quadri = new ArrayList<Quadro>();
		fornitori = new ArrayList<Fornitore>();
		locali = new ArrayList<Locale>();
		clienti = new ArrayList<Cliente>();
	}
	
	public ArrayList<Lavoratore> getLavoratori(){
		return lavoratori;
	}
	
	public ArrayList<Operaio> getOperai(){
		return operai;
	}
	
	public ArrayList<Dirigente> getDirigenti(){
		return dirigenti;
	}
	
	public ArrayList<Quadro> getQuadri(){
		return quadri;
	}
	
	public ArrayList<Impiegato> getImpiegati(){
		return impiegati;
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
	
	public void addLavoratore(Operaio o) {
		lavoratori.add(o);
		operai.add(o);
	}
	
	public void addLavoratore(Impiegato i) {
		lavoratori.add(i);
		impiegati.add(i);
		i.setBusy(true);
	}
	
	public void addLavoratore(Quadro q) {
		lavoratori.add(q);
		quadri.add(q);
	}
	
	public void addLavoratore(Dirigente d) {
		lavoratori.add(d);
		dirigenti.add(d);
		d.setBusy(true);
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
	
	public ArrayList<Locale> getLocaleByCitta(String citta){
		ArrayList<Locale> toBeRet = new ArrayList<Locale>();
		for(Locale l:locali) {
			if(l.getCitta().equals(citta)) {
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
