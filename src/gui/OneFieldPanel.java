package gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OneFieldPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 422818543660009558L;
	private JTextField firstField;
	
	public OneFieldPanel(String label, String field) {
		setLayout(new GridLayout(2, 1));
		JLabel firstLabel = new JLabel(label);
		firstField = new JTextField();
		firstField.setText(field);
		firstField.setEditable(false);
		add(firstLabel);
		add(firstField);
	}
	
	public OneFieldPanel(String label) {
		setLayout(new GridLayout(2, 1));
		JLabel firstLabel = new JLabel(label);
		firstField = new JTextField();
		firstField.setEditable(true);
		add(firstLabel);
		add(firstField);
	}
	
	public String getValue() {
		return firstField.getText(); 
	}
}
