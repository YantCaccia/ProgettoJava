package tester;
import dirigenza.*;
import esterno.*;

public class EsternoTester {

	public static void main(String[] args) {
		
		//Creo un Reparto Amministrativo fittizio
		RepartoAmministrativo ra = new RepartoAmministrativo();
		
		//Testo Cliente
		//Creo tre nuovi clienti
		Cliente c1 = new Cliente("Antonio Cacciapuoti", "60607750613");
		Cliente c2 = new Cliente("Jole Pace", "60607750614");
		Cliente c3 = new Cliente("Fabrizio Carangio", "60607750615");
		
		System.out.println("Clienti\nNome: " + c1.getNome() + ", pIva: " + c1.getpIva());
		System.out.println("Nome: " + c2.getNome() + ", pIva: " + c2.getpIva());
		System.out.println("Nome: " + c3.getNome() + ", pIva: " + c3.getpIva());
		
		//Aggiungo i tre clienti a Reparto Amministrativo
		ra.addCliente(c1);
		ra.addCliente(c2);
		ra.addCliente(c3);
		
		//Stampo la lista
		System.out.println("Lista di Clienti da Reparto Amministrativo: " + ra.getClienti() + "\n");
		
		//Testo Fornitore
		//Creo quattro nuovi fornitori
		Fornitore f1 = new Fornitore("Gabriele Cacciapuoti", "60607750617", Prodotto.ABBIGLIAMENTO);
		Fornitore f2 = new Fornitore("Giacomo Guerra", "60607750618", Prodotto.STRUMENTI);
		Fornitore f3 = new Fornitore("Massimo Pericolo", "60607750619", Prodotto.VEICOLI);
		Fornitore f4 = new Fornitore("Gionata Boschetti", "60607750610", Prodotto.VEICOLI);
		
		System.out.println("Fornitori\nNome: " + f1.getNome() + ", pIva: " + f1.getpIva() + ", Prodotto: " + f1.getProdottoFornito());
		System.out.println("Nome: " + f2.getNome() + ", pIva: " + f2.getpIva() + ", Prodotto: " + f2.getProdottoFornito());
		System.out.println("Nome: " + f3.getNome() + ", pIva: " + f3.getpIva() + ", Prodotto: " + f3.getProdottoFornito());
		System.out.println("Nome: " + f4.getNome() + ", pIva: " + f4.getpIva() + ", Prodotto: " + f4.getProdottoFornito());
		
		//Aggiungo i Fornitori a Reparto Amministrativo
		ra.addFornitore(f1);
		ra.addFornitore(f2);
		ra.addFornitore(f3);
		ra.addFornitore(f4);
				
		//Stampo la lista
		System.out.println("Lista di Fornitori da Reparto Amministrativo: " + ra.getFornitori());
		
		//Stampo la lista ottenuta da Reparto Amministrativo di Fornitori di VEICOLI
		System.out.println("Lista di Fornitori di Veicoli da Reparto Amministrativo: " + ra.getFornitoreByProdotto(Prodotto.VEICOLI) + "\n");
		
		//Testo Locale
		//Creo tre Locali
		Locale l1 = new Locale("Magazzino", "Via Napoli 25", "Villaricca");
		Locale l2 = new Locale("Archivio", "Via Po 11", "Giugliano");
		Locale l3 = new Locale("Ufficio", "Via della Liberta 56", "Villaricca");
		
		System.out.println("Locali\nNome: " + l1.getNome() + ", Indirizzo: " + l1.getIndirizzo() + ", Città: " + l1.getCitta());
		System.out.println("Nome: " + l2.getNome() + ", Indirizzo: " + l2.getIndirizzo() + ", Città: " + l2.getCitta());
		System.out.println("Nome: " + l3.getNome() + ", Indirizzo: " + l3.getIndirizzo() + ", Città: " + l3.getCitta());
		
		//Aggiungo i Locali a Reparto Amministrativo
		ra.addLocale(l1);
		ra.addLocale(l2);
		ra.addLocale(l3);
		
		//Stampo la lista dei Locali
		System.out.println("Lista dei locali: " + ra.getLocali());
		
		//Stampo la lista dei Locali in base alla città
		System.out.println("Lista dei Locali di Villaricca: " + ra.getLocaleByCitta("Villaricca"));
		
	}

}
