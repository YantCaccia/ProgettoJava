package gui;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dirigenza.RepartoAmministrativo;
import dirigenza.RepartoOperativo;
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
	
	public MainFrame(RepartoOperativo ro, RepartoAmministrativo ra) {
		
		mainPanel = new JPanel(new CardLayout());
		cl = (CardLayout) mainPanel.getLayout();
		
		initState = new InitState(cl, mainPanel);
		mainPanel.add(initState);
		cl.addLayoutComponent(initState, "initState");
		
		ROMainState = new RepOpMainState(cl, mainPanel, ro, ra);
		mainPanel.add(ROMainState);
		cl.addLayoutComponent(ROMainState, "RepOp");
		
		RAMainState = new RepAmmMainState(cl, mainPanel, ra);
		mainPanel.add(RAMainState);
		cl.addLayoutComponent(RAMainState, "RepAmm");
		
		FornitoriState = new FornitoriState(cl, mainPanel, ra);
		mainPanel.add(FornitoriState);
		cl.addLayoutComponent(FornitoriState, "FornitoriState");
		
		ClientiState = new ClientiState(cl, mainPanel, ra);
		mainPanel.add(ClientiState);
		cl.addLayoutComponent(ClientiState, "ClientiState");
		
		LocaliState = new LocaliState(cl, mainPanel, ra);
		mainPanel.add(LocaliState);
		cl.addLayoutComponent(LocaliState, "LocaliState");
		
		LavoratoriState = new LavoratoriState(cl, mainPanel, ra);
		mainPanel.add(LavoratoriState);
		cl.addLayoutComponent(LavoratoriState, "LavoratoriState");
		
		add(mainPanel);
	}
}
