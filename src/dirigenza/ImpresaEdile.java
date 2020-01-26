package dirigenza;

import java.io.Serializable;
/**
 * Descrive un'Impresa Edile.
 * Ha un nome, un Reparto Operativo e un Reparto Amministrativo
 * @author antoc
 *
 */
public class ImpresaEdile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8734410082788508033L;
	private String nome;
	private RepartoAmministrativo repAmm;
	private RepartoOperativo repOp;
	
	/**
	 * Istanzia una impresa edile con i parametri specificati
	 * @param nNome il nome
	 * @param ra il Reparto Amministrativo
	 * @param ro il Reparto Operativo
	 */
	public ImpresaEdile(String nNome, RepartoAmministrativo ra, RepartoOperativo ro) {
		nome = (nNome==null?"":nNome);
		repOp = ro;
		repAmm = ra;
	}
	
	/**
	 * accedi al nome dell'impresa
	 * @return il nome
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * accedi al reparto amministrativo dell'impresa
	 * @return il reparto amministrativo
	 */
	public RepartoAmministrativo getRepAmm() {
		return repAmm;
	}
	
	/**
	 * accedi al reparto operativo dell'impresa
	 * @return il reparto operativo
	 */
	public RepartoOperativo getRopOp() {
		return repOp;
	}
	
}
