package gui;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dirigenza.ImpresaEdile;
import gui.mainStates.ClientiState;
import gui.mainStates.FornitoriState;
import gui.mainStates.InitState;
import gui.mainStates.LavoratoriState;
import gui.mainStates.LocaliState;
import gui.mainStates.RepAmmMainState;
import gui.mainStates.RepOpMainState;

/**
 * questo frame istanzia un pannello con CardLayout e vi aggiunge tutti i pannelli responsabili di ogni stato del programma
 * @author antoc
 *
 */
public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 6805379754044482696L;
	JPanel mainPanel, initState, ROMainState, RAMainState, CreateCantiereState, FornitoriState, ClientiState, LocaliState, LavoratoriState;
	CardLayout cl;
	
	public MainFrame(ImpresaEdile ie) {
		
		mainPanel = new JPanel(new CardLayout());
		
		//accedo al Layout Manager del pannello principale
		cl = (CardLayout) mainPanel.getLayout();
		
		initState = new InitState(cl, mainPanel);
		mainPanel.add(initState);
		cl.addLayoutComponent(initState, "initState");
		
		ROMainState = new RepOpMainState(cl, mainPanel, ie.getRopOp(), ie.getRepAmm());
		mainPanel.add(ROMainState);
		cl.addLayoutComponent(ROMainState, "RepOp");
		
		RAMainState = new RepAmmMainState(cl, mainPanel);
		mainPanel.add(RAMainState);
		cl.addLayoutComponent(RAMainState, "RepAmm");
		
		FornitoriState = new FornitoriState(cl, mainPanel, ie.getRepAmm());
		mainPanel.add(FornitoriState);
		cl.addLayoutComponent(FornitoriState, "FornitoriState");
		
		ClientiState = new ClientiState(cl, mainPanel, ie.getRepAmm());
		mainPanel.add(ClientiState);
		cl.addLayoutComponent(ClientiState, "ClientiState");
		
		LocaliState = new LocaliState(cl, mainPanel, ie.getRepAmm());
		mainPanel.add(LocaliState);
		cl.addLayoutComponent(LocaliState, "LocaliState");
		
		LavoratoriState = new LavoratoriState(cl, mainPanel, ie.getRepAmm());
		mainPanel.add(LavoratoriState);
		cl.addLayoutComponent(LavoratoriState, "LavoratoriState");
		
		add(mainPanel);
	}
}
