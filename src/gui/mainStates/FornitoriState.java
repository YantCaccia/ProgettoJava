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
import esterno.Fornitore;
import esterno.Prodotto;
import gui.FrameCreator;
import gui.createStates.CreateFornitoreState;
import utils.Comparator;
import utils.Renderer;
import utils.Sorter;

/**
 * pannello che gestisce lo state sui Fornitori
 * @author antoc
 *
 */
public class FornitoriState extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4634058759811826600L;
	JList<Fornitore> list;
	Fornitore[] larray;
	
	public FornitoriState(CardLayout cl, JPanel mainPanel, RepartoAmministrativo nRa) {
		
		setLayout(new BorderLayout());
		
		JPanel centerPanel = new JPanel(new GridLayout(1, 2)); //per la lista e i pulsanti laterali
		JPanel southPanel = new JPanel(new BorderLayout()); //per il pulsante back
		
		/*Pannello Lista*/
		JPanel listPanel = new JPanel(new BorderLayout());
		
		/*Lista*/
		list = new JList<Fornitore>();
		list.setCellRenderer(new Renderer());
		JScrollPane sb = new JScrollPane(list);
		listPanel.add(sb, BorderLayout.CENTER);
		
		/*Bottone per Ordinare*/
		JButton orderButton = new JButton("Ordina");
		orderButton.addActionListener(e -> {
			if(orderButton.getText().equals("Ordine: per Nome")) {
				orderButton.setText("Ordine: per Prodotto");
				//per prodotto
				ordinaFornitori((c1, c2)->{
					return c1.getProdottoFornito().toString().compareTo(c2.getProdottoFornito().toString());
				});
			}
			else {
				orderButton.setText("Ordine: per Nome");
				//per nome
				ordinaFornitori((c1, c2)->{
					return c1.getNome().compareTo(c2.getNome());
				});
			}			
		});
		listPanel.add(orderButton, BorderLayout.SOUTH);
		
		/*Pannello Pulsanti Laterali*/
		JPanel sidePanel = new JPanel(new GridLayout(7, 1));
		
		JButton abbigliamento = new JButton("Fornitori di Abbigliamento");
		abbigliamento.addActionListener(e -> populateList(nRa.getFornitoreByProdotto(Prodotto.ABBIGLIAMENTO)));
		sidePanel.add(abbigliamento);
		
		JButton veicoli = new JButton("Fornitori di Veicoli");
		veicoli.addActionListener(e -> populateList(nRa.getFornitoreByProdotto(Prodotto.VEICOLI)));
		sidePanel.add(veicoli);
		
		JButton strumenti = new JButton("Fornitori di Strumenti");
		strumenti.addActionListener(e -> populateList(nRa.getFornitoreByProdotto(Prodotto.STRUMENTI)));
		sidePanel.add(strumenti);
		
		JButton matPrima = new JButton("Fornitori di Materia Prima");
		matPrima.addActionListener(e -> populateList(nRa.getFornitoreByProdotto(Prodotto.MATERIAPRIMA)));
		sidePanel.add(matPrima);
		
		JButton reset = new JButton("Tutti i fornitori");
		reset.addActionListener(e -> populateList(nRa.getFornitori()));
		sidePanel.add(reset);
		
		JButton addButton = new JButton("Aggiungi Fornitore");
		addButton.addActionListener(e -> new FrameCreator(new CreateFornitoreState(this, nRa)));
		sidePanel.add(addButton);
		
		JButton removeButton = new JButton("Rimuovi Fornitore");
		removeButton.addActionListener(e -> {
			nRa.removeFornitore(list.getSelectedValue());
			populateList(nRa.getFornitori());
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
				populateList(nRa.getFornitori());
				
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
	
	public void populateList(ArrayList<? extends Fornitore> arrayList) {
		larray = new Fornitore[arrayList.size()];
		arrayList.toArray(larray);
		list.setListData(larray);
		list.updateUI();
		list.repaint();
		list.revalidate();
		list.setSelectedIndex(0);
	}
	
	public void ordinaFornitori(Comparator<Fornitore> comparator) {
		Sorter<Fornitore> sorter = new Sorter<Fornitore>();
		ArrayList<Fornitore> toBeSorted = new ArrayList<Fornitore>();
		for(int i = 0; i< list.getModel().getSize();i++){
		    toBeSorted.add(list.getModel().getElementAt(i));
		}
		populateList(sorter.sort(toBeSorted, comparator));
	}
}
