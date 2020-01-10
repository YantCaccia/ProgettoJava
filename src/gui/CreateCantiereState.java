package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import dipendenti.Operaio;
import dipendenti.Quadro;
import dipendenti.Responsabile;
import dirigenza.LavoratoreImpegnatoException;
import dirigenza.RepartoAmministrativo;
import dirigenza.RepartoOperativo;
import dirigenza.ResponsabileNonDirigenteExcpetion;
import dirigenza.Squadra;
import utils.Renderer;

public class CreateCantiereState extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7253311054339012961L;
	//JTextField nome, valore;
	//JComboBox<Responsabile> resp;
	//JComboBox<Quadro> caposq;
	//Operaio[] larray;
	//JList<Operaio> list;
	
	public CreateCantiereState(RepOpMainState mainState, RepartoOperativo ro, RepartoAmministrativo ra) {
		/*Setto il Layout del Panel Principale*/
		setLayout(new BorderLayout());
		/*Creo il Pannello per l'Input*/
		JPanel inputPanel = new JPanel(new GridLayout(4,1));
		/*Creo il Pannello per i due pulsanti*/
		JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
		
		/*InputPanel*/
		/*Valore Cantiere*/
		JPanel topPanel = new JPanel(new GridLayout(2,1));
		JTextField nome = new JTextField("Nome del Cantiere");
		JTextField valore = new JTextField("Valore del Cantiere");
		topPanel.add(nome);
		topPanel.add(valore);
		inputPanel.add(topPanel);
		
		/*Tendina per Resp*/
		JPanel tendinaPanel = new JPanel(new GridLayout(2,1));
		tendinaPanel.setBackground(Color.WHITE);
		JLabel tendinaLabel = new JLabel("Responsabile Cantiere:");
		tendinaPanel.add(tendinaLabel);
		JComboBox<Responsabile> resp = new JComboBox<Responsabile>();
		resp.setRenderer(new Renderer());
		for(Responsabile r:ra.getDirigenti()) {
			resp.addItem(r);
		}
		for(Responsabile r:ra.getQuadri()) {
			resp.addItem(r);
		}
		tendinaPanel.add(resp);
		inputPanel.add(tendinaPanel);
		
		/*CapoSquadra*/
		JPanel caposqPanel = new JPanel(new GridLayout(2,1));
		caposqPanel.setBackground(Color.WHITE);
		JLabel caposquadraLabel = new JLabel("Caposquadra:");
		JComboBox<Quadro> caposq = new JComboBox<Quadro>();
		caposq.setRenderer(new Renderer());
		for(Quadro q:ra.getQuadriNonImpegnati()) {
			caposq.addItem(q);
		}
		caposqPanel.add(caposquadraLabel);
		caposqPanel.add(caposq);
		inputPanel.add(caposqPanel);
		
		/*ListaOperai*/
		JPanel listaPanel = new JPanel(new GridLayout(2,1));
		listaPanel.setBackground(Color.WHITE);
		JLabel listaLabel = new JLabel("Componenti Squadra: (CTRL + Click)");
		/*Creo una JList*/
		JList<Operaio> list = new JList<Operaio>();
		Operaio[] larray = new Operaio[ra.getOperaiNonImpegnati().size()];
		ra.getOperaiNonImpegnati().toArray(larray);
		list.setListData(larray);
		/*Creo un custom CellRenderer per visualizzare in maniere custom i dati in JList*/
		list.setCellRenderer(new Renderer());
		/*Creo una scrollbar per la lista*/
		JScrollPane sb = new JScrollPane(list);
		listaPanel.add(listaLabel);
		listaPanel.add(sb);
		inputPanel.add(listaPanel);
		
		/*ButtonPanel*/
		JButton ok = new JButton("OK");
		ok.addActionListener(e -> {
				/*Creo un nuovo Cantiere*/
				String nNome = nome.getText();
				int nValue = Integer.parseInt(valore.getText());
				Responsabile nResp = (Responsabile) resp.getSelectedItem();
				Quadro nCapo = (Quadro) caposq.getSelectedItem();
				Squadra s = null;
				try {
					s = ro.createSquadra(nCapo);
					try {
						ro.createCantiere(nNome, nValue, nResp, s);
						for(Operaio o: list.getSelectedValuesList()) {
							try {
								ro.addOperaioToSquadra(o, s);
							} catch (LavoratoreImpegnatoException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}						
					} catch (ResponsabileNonDirigenteExcpetion e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
						ro.freeSquadra(s);
					}
				} catch (LavoratoreImpegnatoException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				/*Aggiorno la lista nel RepOpMainState*/
				mainState.populateList(ro.getCantieri());
				/*Chiudo questo frame*/
				((JFrame)SwingUtilities.getWindowAncestor(this)).dispose();
		});
		buttonPanel.add(ok);
		
		JButton back = new JButton("Back");
		back.addActionListener(e -> ((JFrame)SwingUtilities.getWindowAncestor(this)).dispose());
		buttonPanel.add(back);
		
		
		add(inputPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
	}
}
