package gui.mainStates;

import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * pannello che gestiche lo state principale del Reparto Amministrativo
 * @author antoc
 *
 */
public class RepAmmMainState extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5653987823691416704L;

	public RepAmmMainState(CardLayout cl, JPanel mainPanel) {
		setLayout(new GridLayout(5, 1));
		
		JButton fornitori = new JButton("Fornitori");
		fornitori.addActionListener(e -> cl.show(mainPanel, "FornitoriState"));
		
		JButton locali = new JButton("Locali");
		locali.addActionListener(e -> cl.show(mainPanel, "LocaliState"));
		
		JButton clienti = new JButton("Clienti");
		clienti.addActionListener(e -> cl.show(mainPanel, "ClientiState"));
		
		JButton lavoratori = new JButton("Lavoratori");
		lavoratori.addActionListener(e -> cl.show(mainPanel, "LavoratoriState"));
		
		JButton back = new JButton("Back");
		back.addActionListener(e -> cl.show(mainPanel, "initState"));
		
		add(fornitori);
		add(locali);
		add(clienti);
		add(lavoratori);
		add(back);
	}
}
