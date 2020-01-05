package dirigenza;

public class SquadraIsAlreadyAssignedExcpetion extends RuntimeException {
	
	/**
	 * E' RuntimeExcpetion perchè una Squadra viene creata apposta per un Cantiere: se una squadra già assegnata viene assegnata ad un Cantiere nuovo,
	 * c'e' un errore di programmazione perchè ciò non dovrebbe essere possibile e non rientra nei casi d'uso del software
	 */
	private static final long serialVersionUID = 204090405777265110L;

	public SquadraIsAlreadyAssignedExcpetion() {
		super();
	}
	
	public SquadraIsAlreadyAssignedExcpetion(String err) {
		super(err);
	}
	
}
