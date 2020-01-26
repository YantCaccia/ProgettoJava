package gui.details;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import dipendenti.*;
import gui.panels.OneFieldPanel;
import gui.panels.TwoFieldsPanel;

/**
 * pannello che gestisce lo state sui dettagli di un lavoratore
 * @author antoc
 *
 */
public class DettagliLavoratoreState extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -199185641101344617L;
	
	public DettagliLavoratoreState(Lavoratore l) {
		
		String classType = l.getClass().getName();
		
		setLayout(new BorderLayout());
		
		JPanel centerPanel = new JPanel(new GridLayout(2, 1));		
		
		JPanel lavoratorePanel = new JPanel(new GridLayout(2, 2));
		
		JPanel nomePanel = new JPanel(new GridLayout(2, 1));
		JLabel nomeLabel = new JLabel("Nome");
		JTextField nomeField = new JTextField();
		nomeField.setText(l.getNome());
		nomeField.setEditable(false);
		nomePanel.add(nomeLabel);
		nomePanel.add(nomeField);
		
		JPanel cognomePanel = new JPanel(new GridLayout(2, 1));
		JLabel cognomeLabel = new JLabel("Cognome");
		JTextField cognomeField = new JTextField();
		cognomeField.setText(l.getCognome());
		cognomeField.setEditable(false);
		cognomePanel.add(cognomeLabel);
		cognomePanel.add(cognomeField);
		
		JPanel codFisPanel = new JPanel(new GridLayout(2, 1));
		JLabel codFisLabel = new JLabel("Codice Fiscale");
		JTextField codFisField = new JTextField();
		codFisField.setText(l.getCodFis());
		codFisField.setEditable(false);
		codFisPanel.add(codFisLabel);
		codFisPanel.add(codFisField);
		
		JPanel tipoPanel = new JPanel(new GridLayout(2, 1));
		JLabel tipoLabel = new JLabel("Tipo");
		JTextField tipoField = new JTextField();
		String textToDisplay = null;
		switch (classType) {
		case IMPIEGATO:
			textToDisplay = "Impiegato";
			break;
		case DIRIGENTE:
			textToDisplay = "Dirigente";
			break;
		case QUADRO:
			textToDisplay = "Quadro";
			break;
		case OPERAIO:
			textToDisplay = "Operaio";
			break;
		default:
			break;
		}
		tipoField.setText(textToDisplay);
		tipoField.setEditable(false);
		tipoPanel.add(tipoLabel);
		tipoPanel.add(tipoField);
		
		lavoratorePanel.add(nomePanel);
		lavoratorePanel.add(cognomePanel);
		lavoratorePanel.add(codFisPanel);
		lavoratorePanel.add(tipoPanel);
		
		JPanel subClassDetailPanel;
		
		switch (classType) {
		case IMPIEGATO:
			Impiegato i = (Impiegato) l;
			subClassDetailPanel = new OneFieldPanel("Ore lavoro:", Integer.toString(i.getOreLavoro()));
			break;

		case QUADRO:
			Quadro q = (Quadro) l;
			subClassDetailPanel = new TwoFieldsPanel("busy: ", "" + q.isBusy(), "Numero squadre: ", Integer.toString(q.getNumeroSquadre()));
			break;
			
		case DIRIGENTE:
			Dirigente d = (Dirigente) l;
			subClassDetailPanel = new OneFieldPanel("Ruolo: ", d.getRuolo().toString());
			break;
			
		case OPERAIO:
			Operaio o = (Operaio) l;
			subClassDetailPanel = new TwoFieldsPanel("busy: ", "" + o.isBusy(), "Numero cantieri: ", Integer.toString(o.getNumeroCantieri()));
			break;
		
		default:
			subClassDetailPanel = null;
			break;
		}
		
		centerPanel.add(lavoratorePanel);	
		centerPanel.add(subClassDetailPanel);
		
		/*Pulsante Back*/
		JButton back = new JButton("Back");
		back.addActionListener(e -> ((JFrame)SwingUtilities.getWindowAncestor(this)).dispose());
		
		
		add(centerPanel, BorderLayout.CENTER);
		add(back, BorderLayout.SOUTH);
		
	}
	
	private static final String OPERAIO = "dipendenti.Operaio";
	private static final String DIRIGENTE = "dipendenti.Dirigente";
	private static final String IMPIEGATO = "dipendenti.Impiegato";
	private static final String QUADRO = "dipendenti.Quadro";
	
}
