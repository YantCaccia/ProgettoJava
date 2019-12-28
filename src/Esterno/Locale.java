package Esterno;

public class Locale {

		private String nome;
		private String indirizzo;
		private String città;
		
		public Locale(String nome, String indirizzo, String città) {
			this.nome = (nome==null?"":nome);
			this.indirizzo = (indirizzo==null?"":indirizzo);
			this.città = (città==null?"":città);
		}
		
		public String getNome() {
			return nome;
		}
		
		public String getIndirizzo() {
			return indirizzo;
		}
		
		public String getCitta() {
			return città;
		}
}
