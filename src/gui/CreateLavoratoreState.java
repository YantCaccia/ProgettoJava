package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import dipendenti.*;
import dirigenza.RepartoAmministrativo;

public class CreateLavoratoreState extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -199185648501344617L;
	
	public CreateLavoratoreState(LavoratoriState ls, RepartoAmministrativo ra) {

		JPanel subClassDetailPanel = new JPanel(new CardLayout());
		CardLayout cl = (CardLayout) subClassDetailPanel.getLayout();
		
		OneFieldPanel impiegatoSub = new OneFieldPanel("Ore lavoro: ");
		subClassDetailPanel.add(impiegatoSub);
		cl.addLayoutComponent(impiegatoSub, "impiegatoSub");
		
		OneFieldPanel operaioSub = new OneFieldPanel("Numero cantieri: ");
		subClassDetailPanel.add(operaioSub);
		cl.addLayoutComponent(operaioSub, "operaioSub");
		
		OneFieldPanel quadroSub = new OneFieldPanel("Numero squadre:");
		subClassDetailPanel.add(quadroSub);
		cl.addLayoutComponent(quadroSub, "quadroSub");
		
		ArrayList<String> tmp = new ArrayList<String>();
		for(Ruolo r:Ruolo.values()) {
			tmp.add(r.toString());
		}
		OneComboBoxPanel dirigenteSub = new OneComboBoxPanel("Ruolo: ", tmp);
		subClassDetailPanel.add(dirigenteSub);
		cl.addLayoutComponent(dirigenteSub, "dirigenteSub");
		
		setLayout(new BorderLayout());
		
		JPanel centerPanel = new JPanel(new GridLayout(2, 1));		
		
		JPanel lavoratorePanel = new JPanel(new GridLayout(2, 2));
		
		JPanel nomePanel = new JPanel(new GridLayout(2, 1));
		JLabel nomeLabel = new JLabel("Nome");
		JTextField nomeField = new JTextField();
		nomeField.setEditable(true);
		nomePanel.add(nomeLabel);
		nomePanel.add(nomeField);
		
		JPanel cognomePanel = new JPanel(new GridLayout(2, 1));
		JLabel cognomeLabel = new JLabel("Cognome");
		JTextField cognomeField = new JTextField();
		cognomeField.setEditable(true);
		cognomePanel.add(cognomeLabel);
		cognomePanel.add(cognomeField);
		
		JPanel codFisPanel = new JPanel(new GridLayout(2, 1));
		JLabel codFisLabel = new JLabel("Codice Fiscale");
		JTextField codFisField = new JTextField();
		codFisField.setEditable(true);
		codFisPanel.add(codFisLabel);
		codFisPanel.add(codFisField);
		
		JPanel tipoPanel = new JPanel(new GridLayout(2, 1));
				
		JLabel tipoLabel = new JLabel("Tipo");
		JComboBox<String> tipoField = new JComboBox<String>();
		tipoField.addItem(IMPIEGATO);
		tipoField.addItem(DIRIGENTE);
		tipoField.addItem(OPERAIO);
		tipoField.addItem(QUADRO);
		tipoField.setEditable(true);
		tipoField.setSelectedIndex(0);
		tipoField.addActionListener(e -> {
			String classType = (String) tipoField.getSelectedItem();
			switch (classType) {
			case IMPIEGATO:
				cl.show(subClassDetailPanel, "impiegatoSub");
				break;
			case DIRIGENTE:
				cl.show(subClassDetailPanel, "dirigenteSub");
				break;
			case QUADRO:
				cl.show(subClassDetailPanel, "quadroSub");
				break;
			case OPERAIO:
				cl.show(subClassDetailPanel, "operaioSub");
				break;
			default:
				break;
			}
		});
		
		tipoPanel.add(tipoLabel);
		tipoPanel.add(tipoField);
		
		lavoratorePanel.add(nomePanel);
		lavoratorePanel.add(cognomePanel);
		lavoratorePanel.add(codFisPanel);
		lavoratorePanel.add(tipoPanel);
		
		centerPanel.add(lavoratorePanel);	
		centerPanel.add(subClassDetailPanel);
		
		/*Panel pulsanti*/
		JPanel pulsanti = new JPanel(new GridLayout(1, 2));
		/*Pulsante ok*/
		JButton ok = new JButton("Ok");
		ok.addActionListener(e -> {
			String classType = (String) tipoField.getSelectedItem();
			switch (classType) {
			case IMPIEGATO:
				Impiegato i = new Impiegato(nomeField.getText(), cognomeField.getText(), codFisField.getText(), Integer.parseInt(impiegatoSub.getValue()));
				ra.addLavoratore(i);
				break;
			case DIRIGENTE:
				Dirigente d = new Dirigente(nomeField.getText(), cognomeField.getText(), codFisField.getText(), Ruolo.valueOf(dirigenteSub.getValue()));
				ra.addLavoratore(d);
				break;
			case QUADRO:
				Quadro q = new Quadro(nomeField.getText(), cognomeField.getText(), codFisField.getText(), Integer.parseInt(quadroSub.getValue()));
				ra.addLavoratore(q);
				break;
			case OPERAIO:
				Operaio o = new Operaio(nomeField.getText(), cognomeField.getText(), codFisField.getText(), Integer.parseInt(operaioSub.getValue()));
				ra.addLavoratore(o);
				break;
			default:
				break;
			}
			ls.populateList(ra.getLavoratori());
			((JFrame)SwingUtilities.getWindowAncestor(this)).dispose();
		});
		/*Pulsante Back*/
		JButton back = new JButton("Back");
		back.addActionListener(e -> ((JFrame)SwingUtilities.getWindowAncestor(this)).dispose());
		
		pulsanti.add(back);
		pulsanti.add(ok);
		
		add(centerPanel, BorderLayout.CENTER);
		add(pulsanti, BorderLayout.SOUTH);
		
	}
	
	private static final String OPERAIO = "Operaio";
	private static final String DIRIGENTE = "Dirigente";
	private static final String IMPIEGATO = "Impiegato";
	private static final String QUADRO = "Quadro";
	
}
