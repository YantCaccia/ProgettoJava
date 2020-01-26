package dirigenza;
public class LavoratoreImpegnatoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	public LavoratoreImpegnatoException() {
		super("Il lavoratore che hai cercato di aggiunere e' gia' impegnato!");
	}
	public LavoratoreImpegnatoException(String err) {
		super(err);
	}
}
