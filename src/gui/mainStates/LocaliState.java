package gui.mainStates;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dirigenza.RepartoAmministrativo;
import esterno.Locale;
import gui.FrameCreator;
import gui.createStates.CreateLocaleState;
import utils.Comparator;
import utils.Renderer;
import utils.Sorter;

/**
 * pannello che gestisce lo state sui Locali
 * @author antoc
 *
 */
public class LocaliState extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5889797126421132505L;
	JList<Locale> list;
	Locale[] larray;

	public LocaliState(CardLayout cl, JPanel mainPanel, RepartoAmministrativo nRa) {
		
		setLayout(new BorderLayout());
		
		JPanel centerPanel = new JPanel(new GridLayout(1, 2)); //per la lista e i pulsanti laterali
		JPanel southPanel = new JPanel(new BorderLayout()); //per il pulsante back
		
		/*Pannello Lista*/
		JPanel listPanel = new JPanel(new BorderLayout());
		
		/*Lista*/
		list = new JList<Locale>();
		list.setCellRenderer(new Renderer());
		JScrollPane sb = new JScrollPane(list);
		listPanel.add(sb, BorderLayout.CENTER);
		
		/*Bottone per Ordinare*/
		JButton orderButton = new JButton("Ordina");
		orderButton.addActionListener(e -> {
			if(orderButton.getText().equals("Ordine: per Nome")) {
				orderButton.setText("Ordine: per Citta'");
				//byCitta
				ordinaLocali((l1,l2)->{
					return l1.getCitta().compareTo(l2.getCitta());
				});
			}
			else {
				orderButton.setText("Ordine: per Nome");
				//byNome
				ordinaLocali((l1,l2)->{
					return l1.getNome().compareTo(l2.getNome());
				});
			}			
		});
		listPanel.add(orderButton, BorderLayout.SOUTH);
		
		/*Pannello Pulsanti Laterali*/
		JPanel sidePanel = new JPanel(new GridLayout(2, 1));
		
		JButton addButton = new JButton("Aggiungi Locale");
		addButton.addActionListener(e -> new FrameCreator(new CreateLocaleState(this, nRa)));
		sidePanel.add(addButton);
		
		JButton removeButton = new JButton("Rimuovi Locale");
		removeButton.addActionListener(e -> {
			nRa.removeLocale(list.getSelectedValue());
			populateList(nRa.getLocali());
		});
		sidePanel.add(removeButton);
		
		
		/*Pulsante Back*/
		JButton back = new JButton("Back");
		back.addActionListener(e -> cl.show(mainPanel, "RepAmm"));
		southPanel.add(back, BorderLayout.SOUTH);
		/*--*/
		
		centerPanel.add(listPanel);
		centerPanel.add(sidePanel);
		
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
		
		addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				populateList(nRa.getLocali());
				
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
	
	public void populateList(ArrayList<? extends Locale> arrayList) {
		larray = new Locale[arrayList.size()];
		arrayList.toArray(larray);
		list.setListData(larray);
		list.updateUI();
		list.repaint();
		list.revalidate();
		list.setSelectedIndex(0);
	}
	
	public void ordinaLocali(Comparator<Locale> comparator) {
		Sorter<Locale> sorter = new Sorter<Locale>();
		ArrayList<Locale> toBeSorted = new ArrayList<Locale>();
		for(int i = 0; i< list.getModel().getSize();i++){
		    toBeSorted.add(list.getModel().getElementAt(i));
		}
		populateList(sorter.sort(toBeSorted, comparator));
	}
	
	
	
}
