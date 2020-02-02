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
import esterno.Cliente;
import gui.FrameCreator;
import gui.createStates.CreateClienteState;
import utils.Comparator;
import utils.Renderer;
import utils.Sorter;

/**
 * pannello che gestisce lo state sui clienti
 * @author antoc
 *
 */
public class ClientiState extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6212922101426114555L;
	JList<Cliente> list;
	Cliente[] larray;

	public ClientiState(CardLayout cl, JPanel mainPanel, RepartoAmministrativo nRa) {
		
		setLayout(new BorderLayout());
		
		JPanel centerPanel = new JPanel(new GridLayout(1, 2)); //per la lista e i pulsanti laterali
		JPanel southPanel = new JPanel(new BorderLayout()); //per il pulsante back
		
		/*Pannello Lista*/
		JPanel listPanel = new JPanel(new BorderLayout());
		
		/*Lista*/
		list = new JList<Cliente>();
		list.setCellRenderer(new Renderer());
		JScrollPane sb = new JScrollPane(list);
		listPanel.add(sb, BorderLayout.CENTER);
		
		/*Bottone per Ordinare*/
		JButton orderButton = new JButton("Ordina");
		orderButton.addActionListener(e -> {
				orderButton.setText("Ordine: per Nome");
				ordinaClienti((c1, c2)->{
					return c1.getNome().compareTo(c2.getNome());
				});		
		});
		listPanel.add(orderButton, BorderLayout.SOUTH);
		
		/*Pannello Pulsanti Laterali*/
		JPanel sidePanel = new JPanel(new GridLayout(2, 1));
		
		JButton addButton = new JButton("Aggiungi Cliente");
		addButton.addActionListener(e -> new FrameCreator(new CreateClienteState(this, nRa)));
		sidePanel.add(addButton);
		
		JButton removeButton = new JButton("Rimuovi Cliente");
		removeButton.addActionListener(e -> {
			nRa.removeCliente(list.getSelectedValue());
			populateList(nRa.getClienti());
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
				populateList(nRa.getClienti());
				
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
	
	public void populateList(ArrayList<? extends Cliente> arrayList) {
		larray = new Cliente[arrayList.size()];
		arrayList.toArray(larray);
		list.setListData(larray);
		list.updateUI();
		list.repaint();
		list.revalidate();
		list.setSelectedIndex(0);
	}
	
	public void ordinaClienti(Comparator<Cliente> comparator) {
		Sorter<Cliente> sorter = new Sorter<Cliente>();
		ArrayList<Cliente> toBeSorted = new ArrayList<Cliente>();
		for(int i = 0; i< list.getModel().getSize();i++){
		    toBeSorted.add(list.getModel().getElementAt(i));
		}
		populateList(sorter.sort(toBeSorted, comparator));
	}
	
}
