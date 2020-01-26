package dirigenza;
import java.io.Serializable;
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

/**
 * gestisce il Reparto Amministrativo dell'Impresa Edile
 * @author antoc
 *
 */
public class RepartoAmministrativo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6783399019160291958L;
	private ArrayList<Operaio> operai;
	private ArrayList<Impiegato> impiegati;
	private ArrayList<Dirigente> dirigenti;
	private ArrayList<Quadro> quadri;
	private ArrayList<Fornitore> fornitori;
	private ArrayList<Locale> locali;
	private ArrayList<Cliente> clienti;
	
	/**
	 * Istanzia un nuovo Reparto Amministrativo con tutte le liste vuote.
	 */
	public RepartoAmministrativo() {
		dirigenti = new ArrayList<Dirigente>();
		operai= new ArrayList<Operaio>();
		impiegati = new ArrayList<Impiegato>();
		quadri = new ArrayList<Quadro>();
		fornitori = new ArrayList<Fornitore>();
		locali = new ArrayList<Locale>();
		clienti = new ArrayList<Cliente>();
	}
	
	/**
	 * accedi alla lista di tutti i Lavoratori
	 * @return la lista di tutti i Lavoratori dell'Impresa Edile
	 */
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
	
	/**
	 * accedi alla lista degli Operai
	 * @return la lista degli Operai
	 */
	public ArrayList<Operaio> getOperai(){
		return operai;
	}
	
	/**
	 * accedi alla lista dei Dirigenti
	 * @return la lista dei Dirigenti
	 */
	public ArrayList<Dirigente> getDirigenti(){
		return dirigenti;
	}

	/**
	 * accedi alla lista dei Quadi
	 * @return la lista dei Quadri
	 */
	public ArrayList<Quadro> getQuadri(){
		return quadri;
	}
	
	/**
	 * accedi alla lista deli Impiegati
	 * @return la lista degli Impiegati
	 */
	public ArrayList<Impiegato> getImpiegati(){
		return impiegati;
	}
	
	/**
	 * accedi alla lista dei Fornitori
	 * @return la lista dei Fornitori
	 */
	public ArrayList<Fornitore> getFornitori(){
		return fornitori;
	}
	
	/**
	 * accedi alla lista dei Locali
	 * @return la lista dei Locali
	 */
	public ArrayList<Locale> getLocali(){
		return locali;
	}
	
	/**
	 * accedi alla lista dei Clienti
	 * @return la lista dei Clienti
	 */
	public ArrayList<Cliente> getClienti(){
		return clienti;
	}
	
	/**
	 * aggiungi un Operaio alla lista degli Operai
	 * @param o l'Operaio
	 */
	public void addLavoratore(Operaio o) {
		operai.add(o);
	}
	
	/**
	 * aggiungi un Impiegato alla lista degli Impiegati
	 * @param i l'Impiegato
	 */
	public void addLavoratore(Impiegato i) {
		impiegati.add(i);
	}
	
	/**
	 * aggiungi un Quadro alla lista dei Quadri
	 * @param q il Quadro
	 */
	public void addLavoratore(Quadro q) {
		quadri.add(q);
	}
	
	/**
	 * aggiungi un Dirigente alla lista dei Dirigenti
	 * @param d il Dirigente
	 */
	public void addLavoratore(Dirigente d) {
		dirigenti.add(d);
	}
	
	/**
	 * aggiungi un Fornitore alla lista dei Fornitori
	 * @param f il fornitore
	 */
	public void addFornitore(Fornitore f) {
		fornitori.add(f);
	}
	
	/**
	 * aggiungi un Locale alla lista dei Locali
	 * @param l il Locale
	 */
	public void addLocale(Locale l) {
		locali.add(l);
	}
	
	/**
	 * aggiungi un cliente alla lista dei Clienti
	 * @param c il cliente
	 */
	public void addCliente(Cliente c) {
		clienti.add(c);
	}

	/**
	 * rimuovi un Operaio dalla relativa lista
	 * @param o l'Operaio da rimuovere
	 */
	public void removeLavoratore(Operaio o) {
		operai.remove(o);
	}
	
	/**
	 * rimuovi un Impiegato dalla relativa lista
	 * @param i l'Impiegato da rimuovere
	 */
	public void removeLavoratore(Impiegato i) {
		impiegati.remove(i);
	}
	
	/**
	 * rimuovi un Quadro dalla relativa lista
	 * @param q il Quadro da rimuovere
	 */
	public void removeLavoratore(Quadro q) {
		quadri.remove(q);
	}
	
	/**
	 * rimuovi un Dirigente dalla relativa lista
	 * @param d il Dirigente da rimuovere
	 */
	public void removeLavoratore(Dirigente d) {
		dirigenti.remove(d);
	}
	
	/**
	 * rimuovi un Fornitore dalla relativa lista
	 * @param f il Fornitore da rimuovere
	 */
	public void removeFornitore(Fornitore f) {
		fornitori.remove(f);
	}
	
	/**
	 * rimuovi un Locale dalla relativa lista
	 * @param l il Locale da rimuovere
	 */
	public void removeLocale(Locale l) {
		locali.remove(l);
	}
	
	/**
	 * rimuovi un Cliente dalla relativa lista
	 * @param c il CLiente da rimuovere
	 */
	public void removeCliente(Cliente c) {
		clienti.remove(c);
	}	
	
	/**
	 * Calcola lo stipendio di un Impiegato
	 * @param i l'Impiegato di cui calcolare lo stipendio
	 * @return l'importo dello stipendio
	 */
	public int calcolaStipendio(Impiegato i) {
		return STIPENDIO_BASE + (PAGA_PER_ORA*i.getOreLavoro());
	}
	
	/**
	 * Calcola lo stipendio di un Operaio
	 * @param o l'Operaio di cui calcolare lo stipendio
	 * @return l'importo dello stipendio
	 */
	public int calcolaStipendio(Operaio o) {
		return STIPENDIO_BASE + (PAGA_PER_CANTIERE*o.getNumeroCantieri());
	}
	
	/**
	 * Calcola lo stipendio di un Quadro
	 * @param q il Quadro di cui calcolare lo stipendio
	 * @return l'importo dello stipendio
	 */
	public int calcolaStipendio(Quadro q) {
		return STIPENDIO_BASE + (PAGA_PER_SQUADRA*q.getNumeroSquadre());
	}
	
	/**
	 * Calcola lo stipendio di un Dirigente
	 * @param d il Dirigente di cui calcolare lo stipendio
	 * @return l'importo dello stipendio
	 */
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
	
	/**
	 * ottieni la lista degli Operai non impegnati
	 * @return la lista degli Operai non impegnati
	 */
	public ArrayList<Operaio> getOperaiNonImpegnati(){
		ArrayList<Operaio> toBeRet = new ArrayList<Operaio>();
		for (Operaio l:operai) {
			if(!l.isBusy()) {
				toBeRet.add(l);
			}
		}
		return toBeRet;
	}
	
	/**
	 * ottieni la lista degli operai impegnati
	 * @return la lista degli operai impegnati
	 */
	public ArrayList<Operaio> getOperaiImpegnati(){
		ArrayList<Operaio> toBeRet = new ArrayList<Operaio>();
		for (Operaio l:operai) {
			if(l.isBusy()) {
				toBeRet.add(l);
			}
		}
		return toBeRet;
	}
	
	/**
	 * ottieni la litsa dei Quadri non impegnati
	 * @return la lista dei Quadri non impegnati
	 */
	public ArrayList<Quadro> getQuadriNonImpegnati(){
		ArrayList<Quadro> toBeRet = new ArrayList<Quadro>();
		for (Quadro l:quadri) {
			if(!l.isBusy()) {
				toBeRet.add(l);
			}
		}
		return toBeRet;
	}
	
	/**
	 * ottieni la lista degli Operai impegnati
	 * @return la lista degli Operai impegnati
	 */
	public ArrayList<Quadro> getQuadriImpegnati(){
		ArrayList<Quadro> toBeRet = new ArrayList<Quadro>();
		for (Quadro l:quadri) {
			if(l.isBusy()) {
				toBeRet.add(l);
			}
		}
		return toBeRet;
	}
	
	/**
	 * accedi ad una lista di fornitori con vincolo sul prodotto fornito
	 * @param p il prodotto che i fornitori della lista devono fornire
	 * @return la lista dei fornitori del prodotto specificato
	 */
	public ArrayList<Fornitore> getFornitoreByProdotto(Prodotto p){
		ArrayList<Fornitore> toBeRet = new ArrayList<Fornitore>();
		for(Fornitore f:fornitori) {
			if(f.getProdottoFornito()==p) {
				toBeRet.add(f);
			}
		}
		return toBeRet;
	}
	
	/**
	 * ottieni una lista dei locali con vincolo sulla citta'
	 * @param citta la citta' in cui ogni locale deve essere
	 * @return la lista dei locali nella citta' specificata
	 */
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
