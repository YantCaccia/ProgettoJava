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

	private ArrayList<Operaio> operai;
	private ArrayList<Impiegato> impiegati;
	private ArrayList<Dirigente> dirigenti;
	private ArrayList<Quadro> quadri;
	private ArrayList<Fornitore> fornitori;
	private ArrayList<Locale> locali;
	private ArrayList<Cliente> clienti;
	
	public RepartoAmministrativo() {
		dirigenti = new ArrayList<Dirigente>();
		operai= new ArrayList<Operaio>();
		impiegati = new ArrayList<Impiegato>();
		quadri = new ArrayList<Quadro>();
		fornitori = new ArrayList<Fornitore>();
		locali = new ArrayList<Locale>();
		clienti = new ArrayList<Cliente>();
	}
	
	public ArrayList<Lavoratore> getLavoratori(){
		ArrayList<Lavoratore> lavoratori = new ArrayList<Lavoratore>();
		for(Impiegato l:impiegati) {
			lavoratori.add(l);
		}
		for(Dirigente l:dirigenti) {
			lavoratori.add(l);
		}
		for(Quadro l:quadri) {
			lavoratori.add(l);
		}
		for(Operaio l:operai) {
			lavoratori.add(l);
		}
		return lavoratori;
	}
	
	public ArrayList<Operaio> getOperai(){
		ArrayList<Operaio> toberet = new ArrayList<Operaio>();
		for(Operaio o:operai) {
			toberet.add(o.clone());
		}
		return toberet;
	}
	
	public ArrayList<Dirigente> getDirigenti(){
		ArrayList<Dirigente> toberet = new ArrayList<Dirigente>();
		for(Dirigente d:dirigenti) {
			toberet.add(d.clone());
		}
		return toberet;
	}
	
	public ArrayList<Quadro> getQuadri(){
		ArrayList<Quadro> toberet = new ArrayList<Quadro>();
		for(Quadro q:quadri) {
			toberet.add(q.clone());
		}
		return toberet;
	}
	
	public ArrayList<Impiegato> getImpiegati(){
		ArrayList<Impiegato> toberet = new ArrayList<Impiegato>();
		for(Impiegato i:impiegati) {
			toberet.add(i.clone());
		}
		return toberet;
	}
	
	public ArrayList<Fornitore> getFornitori(){
		ArrayList<Fornitore> toberet = new ArrayList<Fornitore>();
		for(Fornitore f:fornitori) {
			toberet.add(f.clone());
		}
		return toberet;
	}
	
	public ArrayList<Locale> getLocali(){
		ArrayList<Locale> toberet = new ArrayList<Locale>();
		for(Locale l:locali) {
			toberet.add(l.clone());
		}
		return toberet;
	}
	
	public ArrayList<Cliente> getClienti(){
		ArrayList<Cliente> toberet = new ArrayList<Cliente>();
		for(Cliente c:clienti) {
			toberet.add(c.clone());
		}
		return toberet;
	}
	
	public void addLavoratore(Operaio o) {
		operai.add(o);
	}
	
	public void addLavoratore(Impiegato i) {
		impiegati.add(i);
	}
	
	public void addLavoratore(Quadro q) {
		quadri.add(q);
	}
	
	public void addLavoratore(Dirigente d) {
		dirigenti.add(d);
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
			bonus = 4000;
			break;
		case VICEDIRETTORE:
			bonus = 7000;
			break;
		case DIRETTORE:
			bonus = 10000;
			break;
		default:
			bonus = 0; //impossible
		}
		return STIPENDIO_BASE + bonus;
	}
	
	public ArrayList<Operaio> getOperaiNonImpegnati(){
		ArrayList<Operaio> toBeRet = new ArrayList<Operaio>();
		for (Operaio l:operai) {
			if(!l.isBusy()) {
				toBeRet.add(l);
			}
		}
		return toBeRet;
	}
	
	public ArrayList<Operaio> getOperaiImpegnati(){
		ArrayList<Operaio> toBeRet = new ArrayList<Operaio>();
		for (Operaio l:operai) {
			if(l.isBusy()) {
				toBeRet.add(l);
			}
		}
		return toBeRet;
	}
	
	public ArrayList<Quadro> getQuadriNonImpegnati(){
		ArrayList<Quadro> toBeRet = new ArrayList<Quadro>();
		for (Quadro l:quadri) {
			if(!l.isBusy()) {
				toBeRet.add(l);
			}
		}
		return toBeRet;
	}
	
	public ArrayList<Quadro> getQuadriImpegnati(){
		ArrayList<Quadro> toBeRet = new ArrayList<Quadro>();
		for (Quadro l:quadri) {
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
