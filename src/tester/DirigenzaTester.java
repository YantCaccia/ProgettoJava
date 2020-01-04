package tester;
import dirigenza.*;
import dipendenti.*;

public class DirigenzaTester {

	public static void main(String[] args) {
		
		//Testo Reparto Amministrativo
		
		//Istanzio un nuovo Reparto Amministrativo
		RepartoAmministrativo ra = new RepartoAmministrativo();
		System.out.println("/---Testo Reparto Amministrativo---/\n\nIstanzio un Reparto Amministrativo\nCreo nuovi Lavoratori e li aggiungo alla lista");
		
		//Creo nuovi Lavoratori
		Dirigente d1 = new Dirigente("Gabriele", "Cacciapuoti", "CCCGBR", Ruolo.AMMINISTRATORE);
		Dirigente d2 = new Dirigente("Sara", "Mondadori", "MNDSRA", Ruolo.DIRETTORE);
		Impiegato i1 = new Impiegato("Biagio", "Feltrinelli", "FLTBGI", 36);
		Impiegato i2 = new Impiegato("Laura", "Esposito", "ESPLRA", 36);
		Impiegato i3 = new Impiegato("Francesca", "Guerra", "GRRFRN", 40);
		Operaio o1 = new Operaio("Mario", "Rossi", "RSSMRI");
		Operaio o2 = new Operaio("Claudio", "Polverino", "PLVCLD");
		Operaio o3 = new Operaio("Fabrizio", "Pace", "PCEFBR");
		Quadro q1 = new Quadro("Luigi", "Bianchi", "BNCLGI");
		Quadro q2 = new Quadro("Giacomo", "Verdi", "VRDGCM");
		
		//Aggiungo i lavoratori alla lista
		ra.addLavoratore(d1);
		ra.addLavoratore(d2);
		ra.addLavoratore(i1);
		ra.addLavoratore(i2);
		ra.addLavoratore(i3);
		ra.addLavoratore(o1);
		ra.addLavoratore(o2);
		ra.addLavoratore(o3);
		ra.addLavoratore(q1);
		ra.addLavoratore(q2);
		
		//Stampo lista
		System.out.println("Stampo la lista:\n" + ra.getLavoratori());

	}

}
