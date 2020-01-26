package esterno;

import java.io.Serializable;
/**
 * Descrive un Locale dell'Impresa Edile
 * @author antoc
 *
 */
public final class Locale implements Cloneable, Serializable {
	
	private static final long serialVersionUID = -1989919838084205431L;
		private String nome;
		private String indirizzo;
		private String citta;
		
		/**
		 * Istanzia un Locale con i parametri specificati
		 * @param nome descrive in una parola il locale
		 * @param indirizzo l'indirizzo del locale
		 * @param citta la citta' in cui si trova il locale
		 */
		public Locale(String nome, String indirizzo, String citta) {
			this.nome = (nome==null?"":nome);
			this.indirizzo = (indirizzo==null?"":indirizzo);
			this.citta = (citta==null?"":citta);
		}
		
		/**
		 * accedi al nome del locale
		 * @return il nome
		 */
		public String getNome() {
			return nome;
		}
		
		/**
		 * accedi all'indirizzo del locale
		 * @return l'indirizzo
		 */
		public String getIndirizzo() {
			return indirizzo;
		}
		
		/**
		 * accedi alla citta' del locale
		 * @return la citta'
		 */
		public String getCitta() {
			return citta;
		}
		
		public String toString() {
			return getClass().getName() + "[nome=" + nome + ", indirizzo=" + indirizzo + ", citta=" + citta + "]";
		}
		
		public boolean equals(Object o) {
			if(o==null) return false;
			if(getClass()!=o.getClass()) return false;
			Locale l = (Locale) o;
			return nome.equals(l.getNome()) && indirizzo.equals(l.getIndirizzo()) && citta.equals(l.getCitta());
		}
		
		public Locale clone() {
			try {
				Locale clone = (Locale) super.clone();
				return clone;
			}
			catch(CloneNotSupportedException e) {
				return null;
			}
		}
}
