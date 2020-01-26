package gui.panels;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * pannello generico con un field di testo
 * @author antoc
 *
 */
public class OneFieldPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 422818543660009558L;
	private JTextField firstField;
	
	public OneFieldPanel(String label, String field) {
		createPanel(label);
		firstField.setText(field);
		firstField.setEditable(false);
		repaint();
	}
	
	public OneFieldPanel(String label) {
		createPanel(label);
	}
	
	public void createPanel(String label) {
		setLayout(new GridLayout(2, 1));
		JLabel firstLabel = new JLabel(label);
		firstField = new JTextField();
		add(firstLabel);
		add(firstField);
	}
	
	public String getValue() {
		return firstField.getText(); 
	}
}
