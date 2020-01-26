package gui.createStates;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import dirigenza.RepartoAmministrativo;
import esterno.Locale;
import gui.mainStates.LocaliState;

/**
 * pannello che gestisce lo state sulla creazione di un locale
 * @author antoc
 *
 */
public class CreateLocaleState extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8948718785638076947L;

	public CreateLocaleState(LocaliState ls, RepartoAmministrativo ra) {
		
		setLayout(new GridLayout(4,1));
		
		JPanel nomePanel = new JPanel(new GridLayout(2, 1));
		
		JLabel nomeLabel = new JLabel("Nome");
		nomePanel.add(nomeLabel);
		JTextField nomeField = new JTextField();
		nomePanel.add(nomeField);
		
		
		JPanel cittaPanel = new JPanel(new GridLayout(2, 1));
		
		JLabel cittaLabel = new JLabel("Citta'");
		cittaPanel.add(cittaLabel);
		JTextField cittaField = new JTextField();
		cittaPanel.add(cittaField);
		
		JPanel indirizzoPanel = new JPanel(new GridLayout(2, 1));
		
		JLabel indirizzoLabel = new JLabel("Indirizzo");
		indirizzoPanel.add(indirizzoLabel);
		JTextField indirizzoField = new JTextField();
		indirizzoPanel.add(indirizzoField);
		
		JButton ok = new JButton("Ok");
		ok.addActionListener(e -> {
			Locale l = new Locale(nomeField.getText(), indirizzoField.getText(), cittaField.getText());
			ra.addLocale(l);;
			ls.populateList(ra.getLocali());
			((JFrame)SwingUtilities.getWindowAncestor(this)).dispose();
		});
		
		add(nomePanel);
		add(cittaPanel);
		add(indirizzoPanel);
		add(ok);
		
		
	}
}
