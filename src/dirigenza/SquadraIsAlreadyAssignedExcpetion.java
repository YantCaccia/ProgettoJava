package dirigenza;

public class SquadraIsAlreadyAssignedExcpetion extends RuntimeException {
	
	/**
	 * E' RuntimeExcpetion (non controllata) perche' una Squadra viene creata apposta per un Cantiere: se una squadra gia'
	 * assegnata viene assegnata ad un Cantiere nuovo,
	 * c'e' un errore di programmazione perche' cio' non dovrebbe essere possibile e non rientra nei casi d'uso del software
	 */
	private static final long serialVersionUID = 204090405777265110L;

	public SquadraIsAlreadyAssignedExcpetion() {
		super();
	}
	
	public SquadraIsAlreadyAssignedExcpetion(String err) {
		super(err);
	}
	
}
