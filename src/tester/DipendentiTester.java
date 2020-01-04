package tester;
import dipendenti.*;

public class DipendentiTester {

	public static void main(String[] args) {
		
		//Testo la classe Lavoratore
		//Poichè la classe Lavoratore è abstract, testo i metodi di Lavoratore istanziando un Operaio
		
		//Creo un nuovo Operaio
		Operaio l1 = new Operaio("Antonio", "Cacciapuoti", "CCCNTN06");
		System.out.println("/---Testo la classe Lavoratore---/\nPoichè Lavoratore è abstract, testo i metodi di Lavoratore istanziando un Operaio");
		System.out.println("\nCreo un nuovo Operaio\n" + l1);
		
		//Setto il Lavoratore con busy a true
		l1.setBusy(true);
		System.out.println("Ho settato busy a true\nIl Lavoratore " + l1.getNome() + " e' impegnato: " + l1.isBusy());
		
		//Clone di l1
		Operaio l2 = l1.clone();
		System.out.println("\nIl Lavoratore 2 è un clone di Lavoratore 1: " + l2);
		
		//Testo Equals
		System.out.println("Lavoratore 2 equals Lavoratore 1? " + l1.equals(l2));
		
		//Modifico l2
		l2.setBusy(false);
		System.out.println("\nHo modificato il campo busy di Lavoratore 2: " + l2);
		System.out.println("Lavoratore 1: " + l1);
		
		//Testo Equals
		System.out.println("Lavoratore 2 equals Lavoratore 1? " + l1.equals(l2));
		
		
		//Testo Dirigente
		
		//Creo un Dirigente
		Dirigente d1 = new Dirigente("Gabriele", "Cacciapuoti", "CCCGBR", Ruolo.AMMINISTRATORE);
		System.out.println("\n/---Testo la classe Dirigente---/\nCreo un nuovo Dirigente: " + d1);
		
		//Cambio ruolo
		d1.setRuolo(Ruolo.DIRETTORE);
		System.out.println("\nCambio ruolo a Dirigente 1: " + d1);
		
		//Clone
		Dirigente d2 = d1.clone();
		System.out.println("\nDirigente 2 è il clone di Dirigente 1: " + d2);
		
		//Equals
		System.out.println("Dirigente 1 equals Dirigente 2? " + d1.equals(d2));
		
		//Cambio ruolo
		d2.setRuolo(Ruolo.VICEDIRETTORE);
		System.out.println("\nCambio ruolo a Direttore 2\nDirettore 2: " + d2 + "\nDirettore 1: " + d1);
		
		//Testo Impiegato
		Impiegato i1 = new Impiegato("Biagio", "Feltrinelli", "FLTBGI", 36);
		System.out.println("\n/---Testo la classe Impiegato---/\nCreo un Impiegato\n" + i1);
		
		//Cambio ore
		i1.setOreLavoro(40);
		System.out.println("\nCambio le ore di lavoro:\n" + i1);
		
		//Testo Operaio
		Operaio o1 = new Operaio("Mario", "Rossi", "RSSMRI");
		System.out.println("\n/---Testo Operaio---/\nCreo un nuovo Operaio\n" + o1);
		
		//Incremento cantieri
		o1.incrementNumeroCantieri();
		System.out.println("Incremento numero cantieri: " + o1);

		//Testo Quadro
		Quadro q1 = new Quadro("Luigi", "Bianchi", "BNCLGI");
		System.out.println("\n/---Testo Quadro---/\nCreo un nuovo Quadro\n" + q1);
		
		//Incremento cantieri
		q1.incrementNumeroSquadre();
		System.out.println("Incremento numero squadre: " + q1);
		
		
		
		
	}

}
