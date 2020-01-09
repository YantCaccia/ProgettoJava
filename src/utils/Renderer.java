package utils;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import dipendenti.Lavoratore;
import dipendenti.Responsabile;
import dirigenza.Cantiere;

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
		else if (value instanceof Responsabile) {
	        Lavoratore l = (Lavoratore) value;
	        toBeRet += l.getNome() + " " + l.getCognome();
	        return super.getListCellRendererComponent(list, toBeRet, index, isSelected, cellHasFocus);
	    }
		else if (value instanceof Lavoratore) {
	        Lavoratore l = (Lavoratore) value;
	        toBeRet += l.getNome() + " " + l.getCognome();
	        return super.getListCellRendererComponent(list, toBeRet, index, isSelected, cellHasFocus);
	    }
	    return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	}
}
