package gui.panels;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * pannello generico con due campi di testo
 * @author antoc
 *
 */
public class TwoFieldsPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5398247569837914098L;

	public TwoFieldsPanel(String fLabel, String fField, String sLabel, String sField) {
		setLayout(new GridLayout(4, 1));
		
		JLabel firstLabel = new JLabel(fLabel);
		JTextField firstField = new JTextField();
		firstField.setText(fField);
		firstField.setEditable(false);
		
		add(firstLabel);
		add(firstField);
		
		JLabel secondLabel = new JLabel(sLabel);
		JTextField secondField = new JTextField();
		secondField.setText(sField);
		secondField.setEditable(false);
		
		add(secondLabel);
		add(secondField);
	}
}
