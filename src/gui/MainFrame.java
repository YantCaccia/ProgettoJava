package gui;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dirigenza.RepartoOperativo;

public class MainFrame extends JFrame {
	
	JPanel mainPanel, initState, ROMainState;
	CardLayout cl;
	
	public MainFrame(RepartoOperativo ro) {
		
		mainPanel = new JPanel(new CardLayout());
		cl = (CardLayout) mainPanel.getLayout();
		
		initState = new InitState(cl, mainPanel);
		mainPanel.add(initState);
		cl.addLayoutComponent(initState, "initState");
		
		ROMainState = new RepOpMainState(cl, mainPanel, ro);
		mainPanel.add(ROMainState);
		cl.addLayoutComponent(ROMainState, "RepOp");
		
		
		add(mainPanel);
	}
}
