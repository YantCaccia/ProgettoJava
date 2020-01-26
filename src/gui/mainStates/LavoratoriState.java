package gui.mainStates;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dipendenti.*;
import dirigenza.RepartoAmministrativo;
import gui.FrameCreator;
import gui.createStates.CreateLavoratoreState;
import gui.details.DettagliLavoratoreState;
import utils.Comparator;
import utils.LavoratoreByNomeComparator;
import utils.Renderer;
import utils.Sorter;

/**
 * pannello che gestisce lo state dei Lavoratori
 * @author antoc
 *
 */
public class LavoratoriState extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6456826997592474665L;
	JList<Lavoratore> list;
	Lavoratore[] larray;
		
	public LavoratoriState(CardLayout cl, JPanel mainPanel, RepartoAmministrativo nRa) {

		/*Setto il layout del pannello principale*/
		setLayout(new BorderLayout());
		
		/*Creo due pannelli secondari:
		 * Uno per una lista
		 * Uno per un insieme di bottoni*/
		JPanel listPanel = new JPanel(new BorderLayout());
		JPanel buttonPanel = new JPanel(new GridLayout(5,1));
		
		/*Creo un Array di Lavoratore a partire da ro.getLavoratori() per utilizzare JList*/
		/*Creo una JList*/
		list = new JList<Lavoratore>();
		/*La lista viene popolata quando questo Panel è mostrato (v. addComponentListener)*/
		
		/*Creo un custom CellRenderer per visualizzare in maniere custom i dati in JList*/
		list.setCellRenderer(new Renderer());
		/*Creo una scrollbar per la lista*/
		JScrollPane sb = new JScrollPane(list);
		listPanel.add(sb, BorderLayout.CENTER);
		
		/*Bottone per ordinare*/
		JButton orderButton = new JButton("Ordina");
		orderButton.addActionListener(e -> {
				orderButton.setText("Ordine: per Nome");
				ordinaLavoratori(new LavoratoreByNomeComparator());
		});
		
		JPanel buttonInList = new JPanel(new GridLayout(1,1));
		buttonInList.add(orderButton);
		listPanel.add(buttonInList, BorderLayout.SOUTH);
		
		/*Creo i Bottoni*/
		
		JComboBox<String> tendina = new JComboBox<String>();
		tendina.addItem("Tutti");
		tendina.addItem("Impiegati");
		tendina.addItem("Dirigenti");
		tendina.addItem("Quadri");
		tendina.addItem("Quadri impegnati");
		tendina.addItem("Quadri non impegnati");
		tendina.addItem("Operai");
		tendina.addItem("Operai impegnati");
		tendina.addItem("Operai non impegnati");
		tendina.addActionListener(e -> {
			String toDisplay = (String) tendina.getSelectedItem();
			ArrayList<? extends Lavoratore> ltd;
			switch (toDisplay) {
			case "Tutti":
				ltd = nRa.getLavoratori();
				break;
			case "Impiegati":
				ltd = nRa.getImpiegati();
				break;
			case "Dirigenti":
				ltd = nRa.getDirigenti();
				break;
			case "Quadri":
				ltd = nRa.getQuadri();
				break;
			case "Quadri impegnati":
				ltd = nRa.getQuadriImpegnati();
				break;
			case "Quadri non impegnati":
				ltd = nRa.getQuadriNonImpegnati();
				break;
			case "Operai":
				ltd = nRa.getOperai();
				break;
			case "Operai impegnati":
				ltd = nRa.getOperaiImpegnati();
				break;
			case "Operai non impegnati":
				ltd = nRa.getOperaiNonImpegnati();
				break;
			default:
				ltd = null;
				break;
			}
			populateList(ltd);
		});
		buttonPanel.add(tendina);
		
		/*Calcola Stipendio*/
		JButton calcolaStipendio = new JButton("Calcola stipendio");
		calcolaStipendio.addActionListener(e -> {
			Lavoratore l = list.getSelectedValue();
			int stipendio = 0;
			if(l instanceof Dirigente) {
				stipendio = nRa.calcolaStipendio((Dirigente)l);
			}
			if(l instanceof Operaio) {
				stipendio = nRa.calcolaStipendio((Operaio)l);
			}
			if(l instanceof Impiegato) {
				stipendio = nRa.calcolaStipendio((Impiegato)l);
			}
			if(l instanceof Quadro) {
				stipendio = nRa.calcolaStipendio((Quadro)l);
			}
			JOptionPane.showMessageDialog(null, "Stipendio: " + stipendio + "$", "Stipendio", JOptionPane.DEFAULT_OPTION);
		});
		buttonPanel.add(calcolaStipendio);
		
		/*Per Creare un nuovo Lavoratore*/
		JButton create = new JButton("Assumi Lavoratore");
		create.addActionListener(e -> new FrameCreator(new CreateLavoratoreState(this, nRa)));
		buttonPanel.add(create);
		
		/*Per Rimuovere il Lavoratore Selezionato*/
		JButton remove = new JButton("Licenzia Lavoratore");
		remove.addActionListener(e -> {
				Lavoratore l = list.getSelectedValue();
				if(l instanceof Dirigente) {
					nRa.removeLavoratore((Dirigente)l);
				}
				if(l instanceof Operaio) {
					nRa.removeLavoratore((Operaio)l);
				}
				if(l instanceof Impiegato) {
					nRa.removeLavoratore((Impiegato)l);
				}
				if(l instanceof Quadro) {
					nRa.removeLavoratore((Quadro)l);
				}
				populateList(nRa.getLavoratori());
		});
		buttonPanel.add(remove);
		
		/*Per i Dettagli del Lavoratore Selezionato*/
		JButton modify = new JButton("Dettagli Lavoratore");
		modify.addActionListener(e -> new FrameCreator(new DettagliLavoratoreState(list.getSelectedValue())));
		buttonPanel.add(modify);
		
		/*Quest'ultimo bottone e' per tornare allo State precedente*/
		JButton back = new JButton("Back");
		back.addActionListener(e -> cl.show(mainPanel, "RepAmm"));
		
		/*Aggiungo i vari Component al pannello Principale*/
		add(back, BorderLayout.SOUTH);
		add(buttonPanel, BorderLayout.EAST);
		add(listPanel, BorderLayout.CENTER);
		
		addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				populateList(nRa.getLavoratori());
				
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
		
	public void populateList(ArrayList<? extends Lavoratore> arrayList) {
		larray = new Lavoratore[arrayList.size()];
		arrayList.toArray(larray);
		list.setListData(larray);
		list.updateUI();
		list.repaint();
		list.revalidate();
		list.setSelectedIndex(0);
	}
		
	public void ordinaLavoratori(Comparator<Lavoratore> comparator) {
		Sorter<Lavoratore> sorter = new Sorter<Lavoratore>();
		ArrayList<Lavoratore> toBeSorted = new ArrayList<Lavoratore>();
		for(int i = 0; i< list.getModel().getSize();i++){
		    toBeSorted.add(list.getModel().getElementAt(i));
		}
		populateList(sorter.sort(toBeSorted, comparator));
	}
		
}
