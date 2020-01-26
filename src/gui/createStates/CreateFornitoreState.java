package gui.createStates;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import dirigenza.RepartoAmministrativo;
import esterno.Fornitore;
import esterno.Prodotto;
import gui.mainStates.FornitoriState;

/**
 * pannello che gestisce lo state sulla creazione di un fornitore
 * @author antoc
 *
 */
public class CreateFornitoreState extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9135959478752166493L;

	public CreateFornitoreState(FornitoriState fs, RepartoAmministrativo ra) {
		setLayout(new GridLayout(4,1));
		
		JPanel nomePanel = new JPanel(new GridLayout(2, 1));
		
		JLabel nomeLabel = new JLabel("Nome");
		nomePanel.add(nomeLabel);
		JTextField nomeField = new JTextField();
		nomePanel.add(nomeField);
		
		
		JPanel pIvaPanel = new JPanel(new GridLayout(2, 1));
		
		JLabel pIvaLabel = new JLabel("pIva");
		pIvaPanel.add(pIvaLabel);
		JTextField pIvaField = new JTextField();
		pIvaPanel.add(pIvaField);
		
		JPanel prodottoPanel = new JPanel(new GridLayout(2, 1));
		
		JLabel prodottoLabel = new JLabel("Prodotto");
		prodottoPanel.add(prodottoLabel);
		
		JComboBox<Prodotto> prodottoTendina = new JComboBox<Prodotto>();
		prodottoTendina.addItem(Prodotto.ABBIGLIAMENTO);
		prodottoTendina.addItem(Prodotto.MATERIAPRIMA);
		prodottoTendina.addItem(Prodotto.STRUMENTI);
		prodottoTendina.addItem(Prodotto.VEICOLI);
		prodottoPanel.add(prodottoTendina);
		
		JButton ok = new JButton("Ok");
		ok.addActionListener(e -> {
			Fornitore f = new Fornitore(nomeField.getText(), pIvaField.getText(), (Prodotto) prodottoTendina.getSelectedItem());
			ra.addFornitore(f);
			fs.populateList(ra.getFornitori());
			((JFrame)SwingUtilities.getWindowAncestor(this)).dispose();
		});
		
		add(nomePanel);
		add(pIvaPanel);
		add(prodottoPanel);
		add(ok);
		
	}
}
