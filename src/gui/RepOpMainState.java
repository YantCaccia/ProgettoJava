package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import dirigenza.*;
import utils.*;

public class RepOpMainState extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3430770777036368202L;
	JList<Cantiere> list;
	JButton orderButton;
	Cantiere[] larray;
	RepartoOperativo ro;
	RepartoAmministrativo ra;

	public RepOpMainState(CardLayout cl, JPanel mainPanel, RepartoOperativo nRo, RepartoAmministrativo nRa) {
		this.ro = nRo;
		/*Setto il layout del pannello principale*/
		setLayout(new BorderLayout());
		
		/*Creo due pannelli secondari:
		 * Uno per una lista
		 * Uno per un insieme di bottoni*/
		JPanel listPanel = new JPanel(new BorderLayout());
		JPanel buttonPanel = new JPanel(new GridLayout(3,1));
		
		/*Creo un Array di Cantiere a partire da ro.getCantieri() per utilizzare JList*/
		/*Creo una JList*/
		list = new JList<Cantiere>();
		/*Popolo la lista*/
		/*Creo un custom CellRenderer per visualizzare in maniere custom i dati in JList*/
		list.setCellRenderer(new Renderer());
		/*Creo una scrollbar per la lista*/
		JScrollPane sb = new JScrollPane(list);
		listPanel.add(sb, BorderLayout.CENTER);
		
		/*Bottone per ordinare*/
		orderButton = new JButton("Ordina");
		orderButton.addActionListener(e -> {
			if(orderButton.getText().equals("Ordine: per Nome")) {
				orderButton.setText("Ordine: per Valore");
				ordinaCantieri(new CantiereValueComparator());
			}
			else {
				orderButton.setText("Ordine: per Nome");
				ordinaCantieri(new CantiereByNomeComparator());
			}			
		});
		
		/*Bottone per filtrare*/
		JButton filterButton = new JButton("Filtra per valore");
		filterButton.addActionListener(e -> {
			createFrame(new FilterPanel(this, nRo));
		});
		
		JPanel buttonInList = new JPanel(new GridLayout(2,1));
		buttonInList.add(filterButton);
		buttonInList.add(orderButton);
		listPanel.add(buttonInList, BorderLayout.SOUTH);
		
		/*Creo i Bottoni*/
		/*Per Creare un nuovo Cantiere*/
		JButton create = new JButton("Crea Cantiere");
		create.addActionListener(e -> {
			createFrame(new CreateCantiereState(this, nRo, nRa));
		});
		buttonPanel.add(create);
		
		/*Per Rimuovere il Cantiere Selezionato*/
		JButton remove = new JButton("Rimuovi Cantiere");
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ro.removeCantiere(list.getSelectedValue());
				ro.getCantieri().toArray(larray);
				list.setListData(larray);
			}
		});
		buttonPanel.add(remove);
		
		/*Per Modificare il Cantiere Selezionato*/
		JButton modify = new JButton("Dettagli/Modifica Cantiere");
		modify.addActionListener(e -> {
			createFrame(new DettagliCantiereState(nRo, nRa, list.getSelectedValue()));
		});
		buttonPanel.add(modify);
		
		/*Quest'ultimo bottone e' per tornare allo State precedente*/
		JButton back = new JButton("Back");
		back.addActionListener(e -> cl.show(mainPanel, "initState"));
		
		/*Aggiungo i vari Component al pannello Principale*/
		add(back, BorderLayout.SOUTH);
		add(buttonPanel, BorderLayout.EAST);
		add(listPanel, BorderLayout.CENTER);
		
		addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				populateList(ro.getCantieri());
				
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	public void populateList(ArrayList<? extends Cantiere> arrayList) {
		larray = new Cantiere[arrayList.size()];
		arrayList.toArray(larray);
		list.setListData(larray);
		list.updateUI();
		list.repaint();
		list.revalidate();
		list.setSelectedIndex(0);
	}
	
	public void createFrame(JPanel panel) {
		JFrame aF = new JFrame();
		aF.add(panel);
		aF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		aF.setSize(400,550);
		aF.setVisible(true);		
	}
	
	public void ordinaCantieri(Comparator<Cantiere> comparator) {
		Sorter<Cantiere> sorter = new Sorter<Cantiere>();
		ArrayList<Cantiere> toBeSorted = new ArrayList<Cantiere>();
		for(int i = 0; i< list.getModel().getSize();i++){
		    toBeSorted.add(list.getModel().getElementAt(i));
		}
		populateList(sorter.sort(toBeSorted, comparator));
	}
}
