package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import dirigenza.RepartoAmministrativo;
import esterno.Cliente;

public class CreateClienteState extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6486550830310957417L;
	
	
	public CreateClienteState(ClientiState cs, RepartoAmministrativo ra) {
		
		setLayout(new GridLayout(3,1));
		
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
		
		JButton ok = new JButton("Ok");
		ok.addActionListener(e -> {
			Cliente c = new Cliente(nomeField.getText(), pIvaField.getText());
			ra.addCliente(c);
			cs.populateList(ra.getClienti());
			((JFrame)SwingUtilities.getWindowAncestor(this)).dispose();
		});
		
		add(nomePanel);
		add(pIvaPanel);
		add(ok);
		
	}
	
}
