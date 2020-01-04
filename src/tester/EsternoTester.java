package tester;
import esterno.*;

public class EsternoTester {

	public static void main(String[] args) {
		
		//Testo Cliente
		//Creo tre nuovi clienti
		Cliente c1 = new Cliente("Antonio Cacciapuoti", "60607750613");
		Cliente c2 = new Cliente("Jole Pace", "60607750614");
		Cliente c3 = new Cliente("Fabrizio Carangio", "60607750615");
		
		System.out.println("Clienti:");
		System.out.println(c1 + "\n" + c2 + "\n" + c3);
		
		//Testo Fornitore
		//Creo quattro nuovi fornitori
		Fornitore f1 = new Fornitore("Gabriele Cacciapuoti", "60607750617", Prodotto.ABBIGLIAMENTO);
		Fornitore f2 = new Fornitore("Giacomo Guerra", "60607750618", Prodotto.STRUMENTI);
		Fornitore f3 = new Fornitore("Massimo Pericolo", "60607750619", Prodotto.VEICOLI);
		Fornitore f4 = new Fornitore("Gionata Boschetti", "60607750610", Prodotto.VEICOLI);
		
		System.out.println("\nFornitori:");
		System.out.println(f1 + "\n" + f2 + "\n" + f2 + "\n" + f3 + "\n" + f4);
		
		//Testo Locale
		//Creo tre Locali
		Locale l1 = new Locale("Magazzino", "Via Napoli 25", "Villaricca");
		Locale l2 = new Locale("Archivio", "Via Po 11", "Giugliano");
		Locale l3 = new Locale("Ufficio", "Via della Liberta 56", "Villaricca");
		
		System.out.println("\nLocali:");
		System.out.println(l1 + "\n" + l2 + "\n" + l3);
		
	}

}
