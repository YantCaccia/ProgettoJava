package Master;

public class ImpresaEdile {
	
	private String nome;
	@SuppressWarnings("unused")
	private RepartoOperativo repOp;
	@SuppressWarnings("unused")
	private RepartoAmministrativo repAmm;
	
	public ImpresaEdile(String nome) {
		this.nome=(nome==null?"":nome);
		repOp = new RepartoOperativo();
		repAmm = new RepartoAmministrativo();
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome=(nome==null?"":nome);
	}
}
