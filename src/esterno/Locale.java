package esterno;

public class Locale {

		private String nome;
		private String indirizzo;
		private String citta;
		
		public Locale(String nome, String indirizzo, String citta) {
			this.nome = (nome==null?"":nome);
			this.indirizzo = (indirizzo==null?"":indirizzo);
			this.citta = (citta==null?"":citta);
		}
		
		public String getNome() {
			return nome;
		}
		
		public String getIndirizzo() {
			return indirizzo;
		}
		
		public String getCitta() {
			return citta;
		}
		
		public String toString() {
			return getClass().getName() + "[nome=" + nome + ", indirizzo=" + indirizzo + ", citta=" + citta + "]";
		}
}