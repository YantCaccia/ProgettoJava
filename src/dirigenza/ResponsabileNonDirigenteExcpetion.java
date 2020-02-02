package dirigenza;

public class ResponsabileNonDirigenteExcpetion extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ResponsabileNonDirigenteExcpetion(int x) {
		super("Il responsabile di questo cantiere deve essere un dirigente!");
	}
	
	public ResponsabileNonDirigenteExcpetion(String err) {
		super(err);
	}

}
