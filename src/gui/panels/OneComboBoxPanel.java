package gui.panels;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * pannello generico con combo box di T (tipo generico)
 * @author antoc
 *
 */
public class OneComboBoxPanel<T> extends JPanel{
	
	private static final long serialVersionUID = 422349543660009558L;
	private JComboBox<T> firstField;
	
	public OneComboBoxPanel(String label, ArrayList<T> strings) {
		setLayout(new GridLayout(2, 1));
		JLabel firstLabel = new JLabel(label);
		firstField = new JComboBox<T>();
		for(T s:strings) {
			firstField.addItem(s);
		}
		add(firstLabel);
		add(firstField);
	}
	
	public String getValue() {
		return (String) firstField.getSelectedItem();
	}
}