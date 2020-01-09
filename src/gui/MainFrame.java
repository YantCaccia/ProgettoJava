package gui;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dirigenza.RepartoAmministrativo;
import dirigenza.RepartoOperativo;

public class MainFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6805379754044482696L;
	JPanel mainPanel, initState, ROMainState, CreateCantiereState;
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
		
		
		
		add(mainPanel);
	}
}
