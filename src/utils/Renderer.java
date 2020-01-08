package utils;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import dirigenza.Cantiere;

public class Renderer extends DefaultListCellRenderer{
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		String toBeRet = "";
		if (value instanceof Cantiere) {
	        Cantiere ob = (Cantiere) value;
	        toBeRet += ob.getValore();
	        return super.getListCellRendererComponent(list, toBeRet, index, isSelected, cellHasFocus);
	    }
	    return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	}
}
