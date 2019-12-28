import Dipendenti.Dirigente;
import Dipendenti.Impiegato;
import Dipendenti.Operaio;
import Dipendenti.Quadro;
import Dipendenti.Ruolo;
import Master.Cantiere;
import Master.LavoratoreImpegnatoException;
import Master.RepartoAmministrativo;
import Master.RepartoOperativo;
import Master.ResponsabileNonDirigenteExcpetion;
import Master.Squadra;
import Master.SquadraIsAlreadyAssignedExcpetion;

public class Tester {

	public static void main(String[] args) throws LavoratoreImpegnatoException, ResponsabileNonDirigenteExcpetion, SquadraIsAlreadyAssignedExcpetion {
		
		/*Reparti*/
		RepartoAmministrativo ra = new RepartoAmministrativo();
		RepartoOperativo ro = new RepartoOperativo();
		
		/*Operai*/
		Operaio o1 = new Operaio("Antonio", "Cacciapuoti", "000001");
		Operaio o2 = new Operaio("Antonio", "Esposito", "000002");
		Operaio o3 = new Operaio("Antonio", "Cacciapuoti", "000003");
		Operaio o4 = new Operaio("Jole", "Pace", "000004");
		
		Impiegato i1 = new Impiegato("Biagio", "Cacciapuoti", "CCCBGI", 10);
		
		Quadro q1 = new Quadro("Fabrizio", "Pace", "PCEFBR");
		Quadro q2 = new Quadro("Alessandro", "Pace", "PCEFBR");
		Quadro q3 = new Quadro("Fabrizio", "Limone", "PCEFBR");
		
		Dirigente d1 = new Dirigente("Michele", "Granata", "MCHGRN", Ruolo.AMMINISTRATORE);
		
		/*'Assumo' i lavoratori*/
		ra.addLavoratore(o1);
		ra.addLavoratore(o2);
		ra.addLavoratore(o3);
		ra.addLavoratore(o4);
		ra.addLavoratore(i1);
		ra.addLavoratore(q1);
		ra.addLavoratore(d1);
		
		System.out.println(ra.getLavoratori());
		
		/* Creo una squadra
		 * Devo passare necessariamente attraverso il Reparto Operativo */
		Squadra s1 = ro.createSquadra(q1);
		Squadra s2 = ro.createSquadra(q2);
		Squadra s3 = ro.createSquadra(q3);
		
		/* Gestisco la squadra attraverso il Reparto Operativo */
		ro.addOperaioToSquadra(o3, s1);
		ro.addOperaioToSquadra(o2, s2);
		ro.addOperaioToSquadra(o4, s3);
		
		/* Creo un cantiere
		 * Devo passare necessariamente attraverso il Reparto Operativo */
		Cantiere c1 = ro.createCantiere(100, q1, s1);
		Cantiere c2 = ro.createCantiere(233, q1, s2);
		Cantiere c3 = ro.createCantiere(1000, q1, s3);
		
		System.out.println(ro.getCantieri());
		System.out.println(ra.getLavoratoriNonImpegnati());
		
		ro.removeCantiere(c2);
		
		System.out.println(ro.getCantieri());
		System.out.println(ra.getLavoratoriNonImpegnati());

	}

}
