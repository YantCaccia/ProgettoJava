package utils;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import dipendenti.Lavoratore;
import dipendenti.Responsabile;
import dirigenza.Cantiere;
import esterno.Cliente;
import esterno.Fornitore;
import esterno.Locale;

public class Renderer extends DefaultListCellRenderer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2736150355666456466L;

	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		String toBeRet = "";
		if (value instanceof Cantiere) {
	        Cantiere c = (Cantiere) value;
	        toBeRet += c.getNome() + " (" + c.getValore() + "$)";
	        return super.getListCellRendererComponent(list, toBeRet, index, isSelected, cellHasFocus);
	    }
		else if (value instanceof Fornitore) {
	        Fornitore f = (Fornitore) value;
	        toBeRet += f.getNome() + " - " + f.getpIva() + " - " + f.getProdottoFornito();
	        return super.getListCellRendererComponent(list, toBeRet, index, isSelected, cellHasFocus);
	    }
		else if (value instanceof Locale) {
	        Locale l = (Locale) value;
	        toBeRet += l.getNome() + " - " + l.getIndirizzo() + ", " + l.getCitta();
	        return super.getListCellRendererComponent(list, toBeRet, index, isSelected, cellHasFocus);
	    }
		else if (value instanceof Cliente) {
	        Cliente c = (Cliente) value;
	        toBeRet += c.getNome() + " - " + c.getpIva();
	        return super.getListCellRendererComponent(list, toBeRet, index, isSelected, cellHasFocus);
	    }
		else if (value instanceof Responsabile) {
	        Lavoratore l = (Lavoratore) value;
	        toBeRet += l.getCognome() + " " + l.getNome();
	        return super.getListCellRendererComponent(list, toBeRet, index, isSelected, cellHasFocus);
	    }
		else if (value instanceof Lavoratore) {
	        Lavoratore l = (Lavoratore) value;
	        toBeRet += l.getCognome() + " " + l.getNome();
	        return super.getListCellRendererComponent(list, toBeRet, index, isSelected, cellHasFocus);
	    }
	    return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	}
}
