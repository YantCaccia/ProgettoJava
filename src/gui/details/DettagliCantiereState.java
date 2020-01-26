package gui.details;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import dipendenti.Operaio;
import dipendenti.Responsabile;
import dirigenza.Cantiere;
import dirigenza.LavoratoreImpegnatoException;
import dirigenza.RepartoAmministrativo;
import dirigenza.RepartoOperativo;
import dirigenza.ResponsabileNonDirigenteExcpetion;
import utils.Renderer;

/**
 * pannello che gestisce lo state sui dettagli dei cantieri
 * @author antoc
 *
 */
public class DettagliCantiereState extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8710953905529537139L;

	JTextArea squadraArea;
	JList<Operaio> opLibList;
	Cantiere cantiere;
	RepartoAmministrativo ra;
		
	public DettagliCantiereState(RepartoOperativo ro, RepartoAmministrativo ra, Cantiere c){
		this.cantiere = c;
		this.ra = ra;
		
		/*Pannello Principale*/
		setLayout(new BorderLayout());
		/*Pannello in NORTH*/
		JPanel northPanel = new JPanel(new GridLayout(3, 1));
		/*Pannello Nome*/
		JPanel nomePanel = new JPanel(new GridLayout(1, 2));
		
		JLabel nomeLabel = new JLabel("Nome");
		nomePanel.add(nomeLabel);
		
		JTextField nomeField = new JTextField(c.getNome());
		nomePanel.add(nomeField);
		
		/*Pannello Valore*/
		JPanel valorePanel = new JPanel(new GridLayout(1, 2));
		
		JLabel valoreLabel = new JLabel("Valore");
		valorePanel.add(valoreLabel);
		
		JTextField valoreField = new JTextField(Integer.toString(c.getValore()));
		valorePanel.add(valoreField);
		
		/*Pannello Responsabile*/
		JPanel responsabilePanel = new JPanel(new GridLayout(1, 2));
		
		JLabel responsabileLabel = new JLabel("Responsabile");
		responsabilePanel.add(responsabileLabel);
		
		JComboBox<Responsabile> tendinaResp = new JComboBox<Responsabile>();
		for(Responsabile r:ra.getDirigenti()) {
			tendinaResp.addItem(r);
		}
		for(Responsabile r:ra.getQuadri()) {
			tendinaResp.addItem(r);
		}
		tendinaResp.setSelectedItem(c.getResp());
		tendinaResp.setRenderer(new Renderer());
		responsabilePanel.add(tendinaResp);
		/**/
		northPanel.add(nomePanel);
		northPanel.add(valorePanel);
		northPanel.add(responsabilePanel);
		
		/*Pannello in CENTER*/
		JPanel centerPanel = new JPanel(new GridLayout(1, 2));
		/*Pannello Squadra*/
		JPanel squadraPanel = new JPanel(new BorderLayout());
		
		JLabel squadraLabel = new JLabel("Squadra:");
		squadraPanel.add(squadraLabel, BorderLayout.NORTH);
		
		squadraArea = new JTextArea();
		squadraArea.setEditable(false);
		squadraArea.setBorder(BorderFactory.createLineBorder(Color.black));
		populateTextArea();
		squadraPanel.add(squadraArea, BorderLayout.CENTER);
		
		/*Pannello OperaiLiberi*/
		JPanel opLibPanel = new JPanel(new BorderLayout());
		
		JLabel opLibLabel = new JLabel("Operai Liberi:");
		opLibPanel.add(opLibLabel, BorderLayout.NORTH);
		
		opLibList = new JList<Operaio>();
		populateOperaiList();
		opLibList.setCellRenderer(new Renderer());
		opLibList.setBorder(BorderFactory.createLineBorder(Color.black));
		opLibPanel.add(opLibList, BorderLayout.CENTER);
		
		JButton operaiButton = new JButton("Aggiungi alla squadra");
		operaiButton.addActionListener(e -> {
				try {
					ro.addOperaioToSquadra(opLibList.getSelectedValue(), c.getSquadra());
				} catch (LavoratoreImpegnatoException e1) {
					JOptionPane.showMessageDialog(null, "Seleziona un Lavoratore non impegnato"); //impossibile
				}
				populateTextArea();
				populateOperaiList();
		});
		opLibPanel.add(operaiButton, BorderLayout.SOUTH);
		
		centerPanel.add(squadraPanel);
		centerPanel.add(opLibPanel);
		/*Pannello in SOUTH*/
		JPanel southPanel = new JPanel(new GridLayout(1, 1));
		
		/*Bottone Salva*/
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(e -> {
			try {
				c.setNome(nomeField.getText());
				c.setValore(Integer.parseInt(valoreField.getText()));
				ro.changeResponsabileCantiere((Responsabile)tendinaResp.getSelectedItem(), c);
				((JFrame)SwingUtilities.getWindowAncestor(this)).dispose();
			} catch (ResponsabileNonDirigenteExcpetion e1) {
				JOptionPane.showMessageDialog(null, e1.getLocalizedMessage());
			}
		});
		southPanel.add(saveButton);
		
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
	}
	
	public void populateTextArea(){
		squadraArea.setText("Caposquadra: " + cantiere.getSquadra().getCaposquadra().getNome() + " " + cantiere.getSquadra().getCaposquadra().getCognome() + "\n");
		for(Operaio o:cantiere.getSquadra().getListaOperai()) {
			squadraArea.append(o.getNome() + " " + o.getCognome() + "\n");
		}	
	}
	
	public void populateOperaiList() {
		Operaio[] opLibArr = new Operaio[ra.getOperaiNonImpegnati().size()];
		ra.getOperaiNonImpegnati().toArray(opLibArr);
		opLibList.setListData(opLibArr);
		opLibList.updateUI();
		opLibList.repaint();
		opLibList.revalidate();
	}
}
