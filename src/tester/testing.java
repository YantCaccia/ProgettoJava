package tester;

import utils.*;
import dirigenza.*;

import java.util.ArrayList;

import dipendenti.*;

public class testing {

	public static void main(String[] args) {
		
		RepartoAmministrativo ra = new RepartoAmministrativo();

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
		
		
	}

}
