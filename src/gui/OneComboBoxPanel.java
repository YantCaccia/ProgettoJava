package gui;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OneComboBoxPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 422349543660009558L;
	private JComboBox<String> firstField;
	
	public OneComboBoxPanel(String label, ArrayList<String> strings) {
		setLayout(new GridLayout(2, 1));
		JLabel firstLabel = new JLabel(label);
		firstField = new JComboBox<String>();
		for(String s:strings) {
			firstField.addItem(s);
		}
		add(firstLabel);
		add(firstField);
	}
	
	public String getValue() {
		return (String) firstField.getSelectedItem();
	}
}