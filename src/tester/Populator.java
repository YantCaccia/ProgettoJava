package tester;

import dipendenti.Dirigente;
import dipendenti.Impiegato;
import dipendenti.Operaio;
import dipendenti.Quadro;
import dipendenti.Ruolo;
import dirigenza.Cantiere;
import dirigenza.LavoratoreImpegnatoException;
import dirigenza.RepartoAmministrativo;
import dirigenza.RepartoOperativo;
import dirigenza.ResponsabileNonDirigenteExcpetion;
import dirigenza.Squadra;
import dirigenza.SquadraIsAlreadyAssignedExcpetion;
import esterno.Cliente;
import esterno.Fornitore;
import esterno.Locale;
import esterno.Prodotto;

public class Populator {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws LavoratoreImpegnatoException, ResponsabileNonDirigenteExcpetion, SquadraIsAlreadyAssignedExcpetion {
		
		//Istanzio un nuovo Reparto Amministrativo
		RepartoAmministrativo ra = new RepartoAmministrativo();
		
		//Creo nuovi Lavoratori
		Dirigente d1 = new Dirigente("Gabriele", "Cacciapuoti", "CCCGBR", Ruolo.AMMINISTRATORE);
		Dirigente d2 = new Dirigente("Sara", "Mondadori", "MNDSRA", Ruolo.DIRETTORE);
		Dirigente d3 = new Dirigente("Alessia", "Maisto", "MSTLSS", Ruolo.VICEDIRETTORE);
		Dirigente d4 = new Dirigente("Ciro", "Topo", "TOPCIR", Ruolo.VICEDIRETTORE);
		Impiegato i1 = new Impiegato("Biagio", "Feltrinelli", "FLTBGI", 36);
		Impiegato i2 = new Impiegato("Laura", "Esposito", "ESPLRA", 36);
		Impiegato i3 = new Impiegato("Francesca", "Guerra", "GRRFRN", 40);
		Impiegato i4 = new Impiegato("Luigi", "Guarino", "GRNLGU", 40);
		Impiegato i5 = new Impiegato("Andrea", "Ercolino", "RCLNDR", 40);
		Impiegato i6 = new Impiegato("Michele", "Granata", "GRNMCH", 38);
		Operaio o1 = new Operaio("Mario", "Rossi", "RSSMRI", 3);
		Operaio o2 = new Operaio("Claudio", "Polverino", "PLVCLD", 2);
		Operaio o3 = new Operaio("Fabrizio", "Pace", "PCEFBR", 10);
		Operaio o4 = new Operaio("Luigi", "Pace", "PCELGU", 1);
		Operaio o5 = new Operaio("Mario", "Bianchi", "BNCMRA");
		Operaio o6 = new Operaio("Valentino", "Rossi", "RSSVLN");
		Operaio o7 = new Operaio("Gianluigi", "Ardente", "RDNGNL");
		Quadro q1 = new Quadro("Luigi", "Bianchi", "BNCLGI", 3);
		Quadro q2 = new Quadro("Giacomo", "Verdi", "VRDGCM", 2);
		Quadro q3 = new Quadro("Vincenzo", "Bellini", "BLLVNC", 4);
		Quadro q4 = new Quadro("Massimo", "Fusco", "FSCMSS");
		Quadro q5 = new Quadro("Vittorio", "Scarpone", "SCRVTT");
		
		//Aggiungo i lavoratori alla lista
		ra.addLavoratore(d1);
		ra.addLavoratore(d2);
		ra.addLavoratore(d3);
		ra.addLavoratore(d4);
		ra.addLavoratore(i1);
		ra.addLavoratore(i2);
		ra.addLavoratore(i3);
		ra.addLavoratore(i4);
		ra.addLavoratore(i5);
		ra.addLavoratore(i6);
		ra.addLavoratore(o1);
		ra.addLavoratore(o2);
		ra.addLavoratore(o3);
		ra.addLavoratore(o4);
		ra.addLavoratore(o5);
		ra.addLavoratore(o6);
		ra.addLavoratore(o7);
		ra.addLavoratore(q1);
		ra.addLavoratore(q2);
		ra.addLavoratore(q3);
		ra.addLavoratore(q4);
		ra.addLavoratore(q5);
		
		
		//Creo nuovi Fornitori
		Fornitore f1 = new Fornitore("Gabriele Cacciapuoti", "60607750617", Prodotto.ABBIGLIAMENTO);
		Fornitore f2 = new Fornitore("Giacomo Guerra", "60607750618", Prodotto.STRUMENTI);
		Fornitore f3 = new Fornitore("Massimo Pericolo", "60607750619", Prodotto.VEICOLI);
		Fornitore f4 = new Fornitore("Gionata Boschetti", "60607750610", Prodotto.VEICOLI);
		
		ra.addFornitore(f1);
		ra.addFornitore(f2);
		ra.addFornitore(f3);
		ra.addFornitore(f4);
		
		//Creo tre Locali
		Locale l1 = new Locale("Magazzino", "Via Napoli 25", "Villaricca");
		Locale l2 = new Locale("Archivio", "Via Po 11", "Giugliano");
		Locale l3 = new Locale("Ufficio", "Via della Liberta 56", "Villaricca");
		
		ra.addLocale(l1);
		ra.addLocale(l2);
		ra.addLocale(l3);
		
		//Creo tre nuovi clienti
		Cliente c1 = new Cliente("Antonio Cacciapuoti", "60607750613");
		Cliente c2 = new Cliente("Jole Pace", "60607750614");
		Cliente c3 = new Cliente("Fabrizio Carangio", "60607750615");
		
		//Aggiungo i tre clienti a Reparto Amministrativo
		ra.addCliente(c1);
		ra.addCliente(c2);
		ra.addCliente(c3);
		
		//Istanzio un nuovo Reparto Operativo
		RepartoOperativo ro = new RepartoOperativo();
		
		//Creo nuove Squadre
		Squadra s1 = ro.createSquadra(q1);
		ro.addOperaioToSquadra(o1, s1);
		ro.addOperaioToSquadra(o2, s1);
		Squadra s2 = ro.createSquadra(q3);
		ro.addOperaioToSquadra(o4, s2);
		Squadra s3 = ro.createSquadra(q2);
		ro.addOperaioToSquadra(o3, s3);
		
		//Creo nuovi Cantieri
		Cantiere can1 = ro.createCantiere("Scuola", 5000, d1, s1);
		Cantiere can2 = ro.createCantiere("Condominio", 2000, q1, s2);
		Cantiere can3 = ro.createCantiere("Villetta", 7000, d2, s3);

	}

}
