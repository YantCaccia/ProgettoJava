package tester;
import dirigenza.*;
import esterno.Cliente;
import esterno.Fornitore;
import esterno.Locale;
import esterno.Prodotto;
import dipendenti.*;

public class DirigenzaTester {

	public static void main(String[] args) throws LavoratoreImpegnatoException, ResponsabileNonDirigenteExcpetion, SquadraIsAlreadyAssignedExcpetion {
		
		//Testo Reparto Amministrativo
		
		//Istanzio un nuovo Reparto Amministrativo
		RepartoAmministrativo ra = new RepartoAmministrativo();
		System.out.println("/---Testo Reparto Amministrativo---/\n\nIstanzio un Reparto Amministrativo\nCreo nuovi Lavoratori e li aggiungo alla lista\n");
		
		//Creo nuovi Lavoratori
		Dirigente d1 = new Dirigente("Gabriele", "Cacciapuoti", "CCCGBR", Ruolo.AMMINISTRATORE);
		Dirigente d2 = new Dirigente("Sara", "Mondadori", "MNDSRA", Ruolo.DIRETTORE);
		Impiegato i1 = new Impiegato("Biagio", "Feltrinelli", "FLTBGI", 36);
		Impiegato i2 = new Impiegato("Laura", "Esposito", "ESPLRA", 36);
		Impiegato i3 = new Impiegato("Francesca", "Guerra", "GRRFRN", 40);
		Operaio o1 = new Operaio("Mario", "Rossi", "RSSMRI");
		o1.setNumeroCantieri(3);
		Operaio o2 = new Operaio("Claudio", "Polverino", "PLVCLD");
		o2.setNumeroCantieri(2);
		Operaio o3 = new Operaio("Fabrizio", "Pace", "PCEFBR");
		o3.setBusy(true);
		o3.setNumeroCantieri(10);
		Operaio o4 = new Operaio("Luigi", "Pace", "PCELGU");
		o4.setNumeroCantieri(1);
		Quadro q1 = new Quadro("Luigi", "Bianchi", "BNCLGI");
		q1.setNumeroSquadre(3);
		Quadro q2 = new Quadro("Giacomo", "Verdi", "VRDGCM");
		q2.setBusy(true);
		q2.setNumeroSquadre(2);
		Quadro q3 = new Quadro("Vincenzo", "Bellini", "BLLVNC");
		q3.setNumeroSquadre(4);
		
		//Aggiungo i lavoratori alla lista
		ra.addLavoratore(d1);
		ra.addLavoratore(d2);
		ra.addLavoratore(i1);
		ra.addLavoratore(i2);
		ra.addLavoratore(i3);
		ra.addLavoratore(o1);
		ra.addLavoratore(o2);
		ra.addLavoratore(o3);
		ra.addLavoratore(o4);
		ra.addLavoratore(q1);
		ra.addLavoratore(q2);
		ra.addLavoratore(q3);
		
		//Stampo lista di tutti i Lavoratori
		System.out.println("Stampo la lista di tutti i Lavoratori:\n" + ra.getLavoratori());
		
		//Stampo lista degli Impiegati
		System.out.println("\nStampo la lista degli Impiegati:\n" + ra.getImpiegati());
		
		//Stampo la lista dei Dirigenti
		System.out.println("\nStampo la lista dei Dirigenti\n" + ra.getDirigenti());
		
		//Stampo la lista degli Operai
		System.out.println("\nStampo la lista degli Operai\n" + ra.getOperai());
		System.out.println("\nStampo la lista degli Operai impegnati\n" + ra.getOperaiImpegnati());
		System.out.println("\nStampo la lista degli Operai non impegnati\n" + ra.getOperaiNonImpegnati());
		
		//Stampo la lista dei Quadri
		System.out.println("\nStampo la lista dei Quadri\n" + ra.getQuadri());
		System.out.println("\nStampo la lista dei Quadri impegnati\n" + ra.getQuadriImpegnati());
		System.out.println("\nStampo la lista dei Quadri non impegnati\n" + ra.getQuadriNonImpegnati() +"\n");
		
		//Calcolo gli stipendi
		System.out.println("Stipendio calcolato per l'Operaio " + o1.getNome() + " " + o1.getCognome() + ": $" + ra.calcolaStipendio(o1));
		System.out.println("Stipendio calcolato per il Quadro " + q1.getNome() + " " + q1.getCognome() + ": $" + ra.calcolaStipendio(q1));
		System.out.println("Stipendio calcolato per il Dirigente " + d1.getNome() + " " + d1.getCognome() +  ": $" + ra.calcolaStipendio(d1));
		System.out.println("Stipendio calcolato per l'Impiegato " + i1.getNome() + " " + i1.getCognome() +  ": $" + ra.calcolaStipendio(i1));
		
		//Creo nuovi Fornitori
		System.out.println("\nCreo nuovi Fornitori e li aggiungo alla lista\n");
		Fornitore f1 = new Fornitore("Gabriele Cacciapuoti", "60607750617", Prodotto.ABBIGLIAMENTO);
		Fornitore f2 = new Fornitore("Giacomo Guerra", "60607750618", Prodotto.STRUMENTI);
		Fornitore f3 = new Fornitore("Massimo Pericolo", "60607750619", Prodotto.VEICOLI);
		Fornitore f4 = new Fornitore("Gionata Boschetti", "60607750610", Prodotto.VEICOLI);
		
		ra.addFornitore(f1);
		ra.addFornitore(f2);
		ra.addFornitore(f3);
		ra.addFornitore(f4);
		
		//Stampo la lista di Fornitori
		System.out.println("Lista dei Fornitori:\n" + ra.getFornitori());
		System.out.println("Lista dei Fornitori selezionati per tipologia di Prodotto:\n" + ra.getFornitoreByProdotto(Prodotto.VEICOLI));
		
		//Creo tre Locali
		System.out.println("\nCreo nuovi Locali e li aggiungo alla lista\n");
		Locale l1 = new Locale("Magazzino", "Via Napoli 25", "Villaricca");
		Locale l2 = new Locale("Archivio", "Via Po 11", "Giugliano");
		Locale l3 = new Locale("Ufficio", "Via della Liberta 56", "Villaricca");
		
		ra.addLocale(l1);
		ra.addLocale(l2);
		ra.addLocale(l3);
		
		//Stampo la lista dei Locali
		System.out.println("Lista dei locali:\n" + ra.getLocali());
		
		//Stampo la lista dei Locali in base alla città
		System.out.println("Lista dei Locali selezionati secondo una città:\n" + ra.getLocaleByCitta("Villaricca"));
		
		//Creo tre nuovi clienti
		System.out.println("\nCreo nuovi Clienti e li aggiungo alla lista\n");
		Cliente c1 = new Cliente("Antonio Cacciapuoti", "60607750613");
		Cliente c2 = new Cliente("Jole Pace", "60607750614");
		Cliente c3 = new Cliente("Fabrizio Carangio", "60607750615");
		
		//Aggiungo i tre clienti a Reparto Amministrativo
		ra.addCliente(c1);
		ra.addCliente(c2);
		ra.addCliente(c3);
		
		//Stampo la lista
		System.out.println("Lista di Clienti:\n" + ra.getClienti() + "\n");
		
		//Testo Reparto Operativo
		
		//Istanzio un nuovo Reparto Operativo
		RepartoOperativo ro = new RepartoOperativo();
		
		//Creo nuove Squadre
		Squadra s1 = ro.createSquadra(q1);
		ro.addOperaioToSquadra(o1, s1);
		ro.addOperaioToSquadra(o2, s1);
		Squadra s2 = ro.createSquadra(q3);
		ro.addOperaioToSquadra(o4, s2);
		q2.setBusy(false); //per non throware LavoratoreImpegnatoException
		o3.setBusy(false); //idem
		Squadra s3 = ro.createSquadra(q2);
		ro.addOperaioToSquadra(o3, s3);
		System.out.println("Creo nuove squadre attraverso Reparto Operativo\n" + s1 + "\n" + s2 + "\n" + s3);
		
		//Creo nuovi Cantieri
		Cantiere can1 = ro.createCantiere(5000, d1, s1);
		@SuppressWarnings("unused")
		Cantiere can2 = ro.createCantiere(2000, q1, s2);
		Cantiere can3 = ro.createCantiere(7000, d2, s3);
		
		//Stampo lista Cantieri
		System.out.println("\nCreo nuovi Cantieri attraverso Reparto Operativo\nLista Cantieri:\n" + ro.getCantieri());
		System.out.println("\nLista dei Cantieri il cui valore e' compreso tra 5000 e 1000:\n" + ro.getCantieriByValue(5000, 10000));
		
		//Chiudiamo il primo Cantiere
		ro.removeCantiere(can1);
		System.out.println("\nDopo la chiusura del primo cantiere:\n" + ro.getCantieri());
		
		//Cambiamo il Responsabile dell'ultimo cantiere
		ro.changeResponsabileCantiere(q3, can3);
		System.out.println("\nDopo il cambio Responsabile per l'ultimo Cantiere:\n" + ro.getCantieri());
		
		//Testo la Clone di Cantiere
		System.out.println("\nTesto la Clone di Cantiere");
		Cantiere can4 = can3.clone();
		System.out.println("cantiere4 e' un clone di cantiere3\ncantiere3:\n"+ can3 + "\ncantiere4:\n" + can4);
		System.out.println("Modifico cantiere4 (modifico il valore)");
		can4.setValore(1);
		System.out.println("cantiere3:\n"+ can3 + "\ncantiere4:\n" + can4);
		
		

	}

}
